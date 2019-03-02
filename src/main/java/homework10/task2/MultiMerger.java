package homework10.task2;


public class MultiMerger extends Thread {

    private int[] unsorted, sorted;
    private int threadsMax;
    private final static int MAX_THREAD_DEFAULT = 8;

    MultiMerger(int[] arrayIn) {
        this.unsorted = arrayIn;
        this.threadsMax = MAX_THREAD_DEFAULT;
    }

    public MultiMerger(int[] arrayIn, int threadsMax) {
        this.unsorted = arrayIn;
        this.threadsMax = threadsMax;
    }

    public void run() {
        int middle;
        int[] left, right;

        if (unsorted.length > 1) {
            middle = unsorted.length / 2;
            left = new int[middle];
            right = new int[unsorted.length - middle];

            System.arraycopy(unsorted, 0, left, 0, middle);
            System.arraycopy(unsorted, middle, right, 0, unsorted.length - middle);

            if (activeCount() < threadsMax) {
                MultiMerger leftSorter = new MultiMerger(left);
                MultiMerger rightSorter = new MultiMerger(right);
                leftSorter.start();
                rightSorter.start();
                try {
                    leftSorter.join();
                    rightSorter.join();
                    sorted = Merger.merge(leftSorter.getSorted(), rightSorter.getSorted());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                Merger leftSorter = new Merger(left);
                Merger rightSorter = new Merger(right);
                leftSorter.sort();
                rightSorter.sort();
                sorted = Merger.merge(leftSorter.getSorted(), rightSorter.getSorted());
            }
        } else {
            sorted = unsorted;
        }
    }

    private int[] getSorted() {
        return sorted;
    }
}
