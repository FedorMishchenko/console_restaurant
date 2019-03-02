package homework10.task4;


import java.util.Random;

public class TruckLoader implements Runnable{
    private Farm farm;

    TruckLoader(Farm farm){
        this.farm = farm;
    }
    @Override
    public void run() {
        while (true) try {
            Thread.sleep(1000);
            Truck truck = farm.get();
            if (truck != null) {
                Thread.sleep(500);
                truck.add(new Random().nextInt(10));
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
