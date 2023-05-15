package cop2805;

class dynamic extends Thread {
//class extends thread 
	public static int fibonacci(int n){
		int v1=0,v2=1,v3=0;
		for(int i=2 ;i <= n;i++){
			v3 = v1 + v2;
			v1 = v2;
			v2 = v3;
		}
		return v3;
	}

	public void run()
	{
		long startTime = System.currentTimeMillis();
		int n=fibonacci(40);
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime); 
		System.out.println("Dynamic thread found: " +n+" in "+duration+"ms");
	}
}

