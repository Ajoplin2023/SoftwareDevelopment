/**
 * @author aaron
 * @version 1.0
 */
public class Recursive {

    /**
     *
      * @param n is the int submitted in the fibonacci sequence
     *          (example can be 5, as in the
     *          5th number within the fibonacci sequence.)
     * @return the fibonacci number found in spot n after completing the
     * recursion method (fib(n-1)+fib(n-2)
     */
    private static long fibonacciR ( int n){
        if (n <= 1) {
            return n;
        }
        return (fibonacciR(n - 1) + fibonacciR(n - 2));

    }

    /**
     *
     * @param args main function beginning with a loop to insert 1,2,3 ...up to 10 as
     *             the 'n'. The startTime submits a startTime, we assign it to 'i'
     *             we then submit an end time and find the difference to get the
     *             time it took to process 'n' for inputs 1-10.
     */
    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {

            double startTime = System.nanoTime();
            double Timer = (double) fibonacciR(i);
            double endTime = System.nanoTime();
            double recursiveRuntime = endTime - startTime;
            System.out.println(i + " " + recursiveRuntime);

        }


    }
}