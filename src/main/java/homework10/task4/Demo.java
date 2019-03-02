package homework10.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        Farm farm = new Farm();
        TruckFactory factory = new TruckFactory(farm);
        ExecutorService service = Executors.newFixedThreadPool(Runtime
                .getRuntime()
                .availableProcessors());
        service.execute(factory);
        for(int i = 0; i < 5; i++){
            service.execute(new TruckLoader(farm));
        }
        service.shutdown();
    }
}