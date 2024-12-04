class Loader extends Thread {
    private final Warehouse warehouse;
    private final int loadWeight; 

    public Loader(Warehouse warehouse, int loadWeight) {
        this.warehouse = warehouse;
        this.loadWeight = loadWeight;
    }

    @Override
    public void run() {
        try {
            warehouse.loadGoods(loadWeight);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

