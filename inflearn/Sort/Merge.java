package Joshua.PS.Inflearn;

/**
 * Created by Joshua on 2017-06-27.
 */
public class Merge {
    public static void main(String[] args) {
        new Merge().run();
    }

    public void run() {
        int[] test = {46, 53, 86, 98, 1, 79, 51, 43, 55, 16, 67, 56, 36, 50, 24, 90, 73, 15, 82, 60, 77, 27, 57, 30, 71, 22, 92, 13, 83, 81, 69, 7, 3, 88, 72, 12, 48, 80, 9, 52, 58, 85, 63, 41, 29, 32, 17, 19, 62, 61, 70, 84, 97, 99, 87, 78, 96, 95, 49, 100, 74, 37, 35, 44, 33, 14, 45, 59, 54, 5, 65, 18, 4, 6, 66, 93, 76, 47, 91, 2, 26, 21, 89, 28, 75, 38, 68, 11, 42, 40, 25, 39, 64, 94, 31, 8, 20, 23, 10, 34};
        mergeSort(test, 0, test.length-1);

        for(int a : test) {
            System.out.print(a + " ");
        }
    }

    public void mergeSort(int array[], int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q+1, r);
            merge(array, p, q, r);
        }
    }

    public void merge(int[] array, int p, int q, int r) {
        int i = p, j = q+1, k = p;
        int[] tmp = new int[array.length];

        while(i <= q && j <= r) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        while(i <= q) {
            tmp[k++] = array[i++];
        }
        while(j <= r) {
            tmp[k++] = array[j++];
        }
        for(int l = p; l <= r; l++) {
            array[l] = tmp[l];
        }
    }
}
