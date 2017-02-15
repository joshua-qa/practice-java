package Joshua.DS.Sort;

/**
 * Created by Joshua on 2017-02-15.
 */
public class InsertionSort {
    private static void insert(int[] array, int rightIndex, int value) {
        int currentIndex;

        for(currentIndex = rightIndex; currentIndex >= 0 && array[currentIndex] > value; currentIndex--) {
            array[currentIndex + 1] = array[currentIndex];
        }

        array[currentIndex + 1] = value;
    }

    private static void sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            insert(array, i-1, array[i]);
        }
    }

    public static void main(String[] args) {
        int[] sortArray = {5, 9, 7, -3, 73, 17, 96, 54, 0};

        sort(sortArray);

        for(int i = 0; i < sortArray.length; i++) {
            System.out.print(sortArray[i] + " ");
        }
    }
}
