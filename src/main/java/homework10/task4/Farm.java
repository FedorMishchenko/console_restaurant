package homework10.task4;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

 class Farm {
    private static final Logger log = Logger.getLogger(Farm.class);
    private List<Truck> store;
    private static final int MAX_LOAD = 5;
    private static final int MIN_LOAD = 0;
    private int counter = 0;

    Farm(){
        store = new ArrayList<>();
    }
     synchronized boolean add(Truck truck){
        try {
            if(counter < MAX_LOAD){
                store.add(truck);
                log.info("     Store added: " + store.size());
                counter++;
            }else {
                log.info("     Store is full. Truck loading...");
                notifyAll();
                wait(3000);
                return false;
            }
        }catch (InterruptedException e){
            log.warn(e.getMessage());
        }
        return true;
    }

     synchronized Truck get(){
        try {
            if(counter > MIN_LOAD){
                for (Iterator<Truck> iterator = store.iterator(); iterator.hasNext(); ) {
                    Truck truck = iterator.next();
                    counter--;
                    log.info("     Store size = " + store.size());
                    log.info("     Truck " + truck.getNumber()
                            + " loading...");
                    store.remove(truck);
                    return truck;
                }
            }
            log.info("     Store is empty");
            notifyAll();
            wait();
        }catch (InterruptedException e){
            log.warn(e.getStackTrace());
        }
        return null;
    }
}
