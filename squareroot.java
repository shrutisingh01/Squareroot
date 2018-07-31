
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class squareroot {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		double sum = 0;
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 1; i < 10; i++) {		
		Future<Double> result = executor.submit(new Mycallable(i));
		sum = sum + result.get();
		}
		System.out.println("Submitted callable task");
		System.out.println("Result from callable is " +sum);
		System.out.println("Finished");
	}

}

class Mycallable implements Callable<Double>{
	double i;
	
	public Mycallable(int input) {
		i = input;
	}

	@Override
	public Double call() throws Exception {
		double sq_root = Math.sqrt(i);
		return sq_root;
	}
	
}

