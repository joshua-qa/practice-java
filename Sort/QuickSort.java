package Joshua.DS.Sort;

import java.util.Arrays;

/**
 * Created by Joshua on 2017-10-27.
 */
public class QuickSort {
    static final int SIZE = 100000000;
    public static int[] array = new int[SIZE];
    private static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static int partition(int pivot, int start, int end) {
        swap(pivot, end);
        int i = start;
        int j = end-1;
        pivot = array[end];
        while(i <= j) {
            while(i <= end-1 && array[i] < pivot) {
                i++;
            }
            while(j >= 0 && array[j] > pivot) {
                j--;
            }

            if(i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        swap(i, end);
        return i;
    }

    private static void quickSort(int start, int end) {
        if(start < end) {
            int pivot = partition((start+end)/2, start, end);
            quickSort(start, pivot-1);
            quickSort(pivot+1, end);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < SIZE; i++) {
            array[i] = (int)(Math.random() * 1000000);
        }

        quickSort(0, SIZE-1);
        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
    }
}
