package Joshua.DS.Sort;

/**
 * Created by Joshua on 2017-02-15.
 */
public class SelectionSort {
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int numTemp;
        numTemp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = numTemp;
    }

    private static int indexOfMinimum(int[] array, int startIndex) {
        int minIndex = startIndex;
        int minValue = array[minIndex];

        for(int i = minIndex + 1; i < array.length; i++) {
            if(minValue > array[i]) {
                minIndex = i;
                minValue = array[minIndex];
            }
        }

        return minIndex;
    }

    private static void sort(int[] array) {
        int currentMin;

        for(int i = 0; i < array.length; i++) {
            currentMin = indexOfMinimum(array, i);
            swap(array, i, currentMin);
        }
    }

    public static void main(String[] args) {
        int[] sortArray = {7, 3, 5, 47, -1, 0, 108, 97};

        sort(sortArray);

        for(int i = 0; i < sortArray.length; i++) {
            System.out.print(sortArray[i] + " ");
        }
    }
}
