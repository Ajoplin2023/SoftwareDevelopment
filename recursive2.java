package cop2805;

class recursive2 extends Thread {
public static int fibonacci(int n){
if(n == 0) return 0;
if(n == 1) return 1;
return fibonacci(n-1) + fibonacci(n-2);
}

public void run()
{
long timer=System.currentTimeMillis();
int n=fibonacci(40);
timer=System.currentTimeMillis()-timer;
System.out.println("Recursion thread found: " +n+" in "+timer+"ms");
}
}