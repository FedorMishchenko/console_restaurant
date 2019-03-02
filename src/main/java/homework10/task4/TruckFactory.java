package homework10.task4;


public class TruckFactory implements Runnable {
    private Farm farm;
    private  int num = 1;

    TruckFactory(Farm farm){
        this.farm = farm;
    }

    @Override
    public void run() {

        while (true){
            farm.add(new Truck(num));
            num++;
            if(num > 6){
                num = 1;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

