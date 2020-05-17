public class MaxHeap {

    private Long[] heap;

    private int size;

    private int lastIndex = 0;

    private static final int DEFAULT_SIZE = 10;

    private static final int CAPACITY_INCREMENT_SIZE = 10;

    public MaxHeap() {
        this(DEFAULT_SIZE);
    }

    public MaxHeap(int size) {
        this.size = size;
        this.heap = new Long[size+1];
    }

    public void add(long num) {
        if (lastIndex == size) {
            ensureCapacity();
        }
        heap[++lastIndex] = num;
        swim(lastIndex);
    }

    private boolean less(int key, int target) {
        return heap[key] < heap[target];
    }

    private void swap(int key, int target) {
        long temp = heap[key];
        heap[key] = heap[target];
        heap[target] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (k*2 <= lastIndex) {
            int j = k*2;
            if (j < lastIndex && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public Long pop() {
        if (lastIndex == 0) {
            return null;
        }
        Long maxValue = heap[1];
        remove();
        return maxValue;
    }

    private void remove() {
        if (lastIndex == 0) {
            return;
        }
        heap[1] = heap[lastIndex--];
        heap[lastIndex+1] = null;
        sink(1);
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= lastIndex; i++) {
            sb.append(heap[i]).append(" ");
        }
        System.out.println(sb);
    }

    private void ensureCapacity() {
        Long[] temp = new Long[heap.length + CAPACITY_INCREMENT_SIZE];
        for (int i = 1; i <= lastIndex; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
        size = temp.length-1;
    }
}
