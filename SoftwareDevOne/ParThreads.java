import java.util.Random;

class ParThreads extends Thread {
    private final int[] array;
    private final int small ;
    private final int high;
    private int partial;

    public ParThreads(int[] array, int low, int high) {
        this.array = array;
        this.small = low;
        this.high = Math.min(high, array.length);
    }
    public int getPartialSum() {
        return partial;
    }

    public void run() {
        partial = sum(array, small, high);
    }
    public static int sum(int[] array) {
        return sum(array, 0, array.length);
    }
    public static int sum(int[] array, int small, int high) {
        int total = 0;
        for (int i = small; i < high; i++) {
            total += array[i];
        }
        return total;
    }
    public static int parallelSum(int[] array) {
        return parallelSum(array, Runtime.getRuntime().availableProcessors());
    }
    public static int parallelSum(int[] array, int threads) {

        int size = (int) Math.ceil(array.length * 1.0 / threads);
        ParThreads[] sums = new ParThreads[threads];
        for (int i = 0; i < threads; i++) {
            sums[i] = new ParThreads(array, i * size, (i + 1) * size);
            sums[i].start();
        }
        try {
            for (ParThreads sum : sums) {
                sum.join();
            }

        } catch (InterruptedException e) {
        }
        int total = 0;
        for (ParThreads sum : sums) {
            total += sum.getPartialSum();
        }
        return total;
    }

    public static void main(String[]args){

                    Random random = new Random();
                    int myArray[] = new int[200000000];
                    int sum = 0;
                    for (int i = 0; i < myArray.length; i++) {
                        myArray[i] = (int)(Math.random()*10);
                    }
                    /*for (int counter = 0; counter < myArray.length; counter++)
                        sum += myArray[counter];
                    System.out.println(sum);
                }*/
        long start = System.currentTimeMillis();
        System.out.println(ParThreads.sum(myArray));
        System.out.println("Single Thread Sum: " + (System.currentTimeMillis() - start)+"ms");

        start = System.currentTimeMillis();
        System.out.println(ParThreads.parallelSum(myArray));
        System.out.println("Parallel Array Sum: " + (System.currentTimeMillis() - start)+"ms");

        //System.out.println("value : " + sum);
}
}

