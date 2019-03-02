package homework10.task2;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

public class MergerHandler {
    private static final Logger log = Logger.getLogger(MergerHandler.class);

    public static void main(String[] args) {
        handler();

    }
    private static void handler(){

        int[] unsorted = new int[1_000_000];
        long startTime, endTime;
        for (int i = 0; i < 1_000_000; i++) {
            unsorted[i] = ThreadLocalRandom.current().nextInt(100);
        }
        startTime = System.currentTimeMillis();
        Merger sorter = new Merger(unsorted);
        sorter.sort();
        endTime = System.currentTimeMillis();
        printTime("Single thread", startTime, endTime);
        startTime = System.currentTimeMillis();
        MultiMerger multiSorter = new MultiMerger(unsorted);
        multiSorter.start();
        try {
            multiSorter.join();
        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        endTime = System.currentTimeMillis();
        printTime("Multi thread", startTime, endTime);
    }

    private static void printTime(String type, long startTime, long endTime){
        String str = type + " sort : " + (double) (endTime - startTime) / 1000 +
                " seconds" + '\n';
        System.out.println(str);
    }
}
