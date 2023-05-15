package cop2805;

public class threadClass extends Thread {
	public void run() {
		
	}
	public static void main(String[] args)
	{
		recursive recur=new recursive();
		recur.start();
		dynamic dynam=new dynamic();
		dynam.start();

	}
}
