/**
 * @author aaron
 * @version 1.0
 */
public class Iteration {
    /**
     *
     * @param n is the input and location for the fibonacci number located at n.
     *          for example if n = 20, the method..
     * @return the 20th fibonacci number using the iteration method.
     *      *
     */
    private static long fibonacciI ( int n) {
        int i, a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
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
            double Timer = (double) fibonacciI(i);
            double endTime = System.nanoTime();
            double iterationRuntime = endTime - startTime;
            System.out.println(i + " " + iterationRuntime);

        }

    }
}
