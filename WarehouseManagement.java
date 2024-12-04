public class WarehouseManagement {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

       
        Loader loader1 = new Loader(warehouse, 70);
        Loader loader2 = new Loader(warehouse, 50);
        Loader loader3 = new Loader(warehouse, 40);
        

        loader1.start();
        loader2.start();
        loader3.start();
       
        
      
        try {
            loader1.join();
            loader2.join();
            loader3.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

