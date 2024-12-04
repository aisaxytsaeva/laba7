public class Matrix {
    public static void main(String[] args) throws InterruptedException{
        int[][] matrix = {{127, 2, 30}, {45, 50, 86}, {76, 8, 9}};

        int rows = matrix.length;
        Thread[] threads = new Thread[rows];
        int[] maxinrows = new int[rows];

        for(int i = 0; i < rows; i++){
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int value : matrix[rowIndex]) {
                    maxInRow = Math.max(maxInRow, value);
                }
                maxinrows[rowIndex] = maxInRow;
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        

        int globalMax = Integer.MIN_VALUE;
        for (int max : maxinrows) {
            globalMax = Math.max(globalMax, max);
        }
    
        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
    
}
