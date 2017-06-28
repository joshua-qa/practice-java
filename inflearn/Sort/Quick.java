package Joshua.PS.Inflearn;

/**
 * Created by Joshua on 2017-06-28.
 */
public class Quick {
    public static void main(String[] args) {
        new Quick().run();
    }

    private void run() {
        int[] array = {2, 17, 96, 25, 43, 1, 9, 8, 22, 68};

        quickSort(array, 0, array.length-1);
        for(int i : array) {
            System.out.println(i);
        }
    }

    private void quickSort(int[] array, int p, int r) {
        if(p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }
    }

    private int partition(int[] array, int p, int r) {
        int x = array[r];

        int i = p-1;

        for(int j = p; j < r; j++) {
            if(array[j] <= x) {
                i = i+1;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        int tmp = array[i+1];
        array[i+1] = array[r];
        array[r] = tmp;

        return i+1;
    }
}
