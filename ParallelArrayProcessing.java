
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ParallelArrayProcessing {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 2;
        int chunkSize = (int) Math.ceil(array.length / (double) numThreads);
        
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        Future<Integer>[] results = new Future[numThreads];


        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, array.length);

            results[i] = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum; 
            });
        }


        executor.shutdown();

        
        int totalSum = 0;
        for (Future<Integer> result : results) {
            totalSum += result.get();
        }

        
        System.out.println("Сумма элементов массива: " + totalSum);
    }
    
}
