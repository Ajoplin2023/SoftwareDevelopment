package cop2805;

public class recursive extends Thread{

	public static int fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return (fibonacci(n-1))+(fibonacci (n-2));
	}
	public void run()
	{
		long startTime = System.currentTimeMillis();
		int n=fibonacci(40);
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime); 
		System.out.println("Recursion thread found " + (n)+ " in "  + duration + "ms");


	}
}


