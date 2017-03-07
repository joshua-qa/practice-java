package Joshua.DS.Sort;

/**
 * Created by Joshua on 2017-03-08.
 */
public class QuickSort {
    public static int[] array = new int[100000000];
    private static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void sort(int start, int end) {
        if(start < end) {
            int p = start, l = start+1, r = end;

            while(l <= r) {
                while(l <= end && array[l] <= array[p]) {
                    l++;
                }
                while(r >= start+1 && array[r] >= array[p]) {
                    r--;
                }
                if(l < r) {
                    swap(l, r);
                }
            }
            swap(p, r);
            sort(start, r-1);
            sort(r+1, end);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 100000000;
        for(int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 1000000);
        }
        sort(0, n-1);

        long end = System.currentTimeMillis();

        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
    }
}
