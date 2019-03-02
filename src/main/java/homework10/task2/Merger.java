package homework10.task2;

 class Merger {

    private int[] unsorted, sorted;

    Merger(int[] arrayIn){
        this.unsorted = arrayIn;
    }

     void sort(){
        int middle;
        int[] left, right;

        if (unsorted.length > 1){
            middle = unsorted.length / 2;
            left = new int[middle];
            right = new int[unsorted.length - middle];

            copy(middle, left, right);
            Merger leftSorter = new Merger(left);
            Merger rightSorter = new Merger(right);

            leftSorter.sort();
            rightSorter.sort();
            sorted = merge(leftSorter.getSorted(), rightSorter.getSorted());
        } else {
            sorted = unsorted;
        }
    }

    private void copy(int middle, int[] left, int[] right) {
        System.arraycopy(unsorted, 0, left, 0, middle);
        System.arraycopy(unsorted, middle, right, 0, unsorted.length - middle);
    }

    static int[] merge(int[] leftArray, int[] rightArray){
        int pointLeft = 0;
        int pointRight = 0;
        int counter = 0;
        int[] mergedArray = new int[leftArray.length + rightArray.length];

        while (pointLeft < leftArray.length && pointRight < rightArray.length){
            if (leftArray[pointLeft] <= rightArray[pointRight]) {
                mergedArray[counter] = leftArray[pointLeft];
                pointLeft++;
            } else {
                mergedArray[counter] = rightArray[pointRight];
                pointRight++;
            }
            counter++;
        }

        if (pointLeft < leftArray.length) {
            System.arraycopy(leftArray, pointLeft, mergedArray, counter, mergedArray.length - counter);
        }
        if (pointRight < rightArray.length) {
            System.arraycopy(rightArray, pointRight, mergedArray, counter, mergedArray.length - counter);
        }

        return mergedArray;
    }

    int[] getSorted() {
        return sorted;
    }

}
