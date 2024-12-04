
import java.util.concurrent.Semaphore;

public class Warehouse {
    private static final int max_weight = 150;
    private int current_weight;
    private final Semaphore semaphore = new Semaphore(1);

    public void loadGoods(int weight) throws InterruptedException {
        semaphore.acquire();
        try {
            
            if (current_weight + weight <= max_weight) {
                current_weight += weight;
                System.out.println(Thread.currentThread().getName() + " загрузил " + weight + " кг. Текущий вес: " + current_weight + " кг.");
            } else {
                System.out.println(Thread.currentThread().getName() + " не смог загрузить " + weight + " кг. Текущий вес: " + current_weight + " кг.");
            }
        } finally {
            
            if (current_weight >= max_weight) {
                unloadGoods();
            }
            semaphore.release(); 
        }
    }
    private void unloadGoods() {
        System.out.println(Thread.currentThread().getName() + " разгружает товары весом: " + current_weight + " кг.");
        current_weight = 0;
    }

    
}
