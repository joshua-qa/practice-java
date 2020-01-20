import java.util.Arrays;

public class MaxHeap {

    private long[] heap;

    private int size;

    private int lastIndex = 1;

    private static final int DEFAULT_SIZE = 10;

    private static final int CAPACITY_INCREMENT_SIZE = 10;

    public MaxHeap() {
        this(DEFAULT_SIZE);
    }

    public MaxHeap(int size) {
        this.size = size;
        this.heap = new long[size+1];
    }

    public void add(long num) {
        if (lastIndex == size) {
            ensureCapacity();
        }
        heap[lastIndex++] = num;
        int currentIndex = lastIndex - 1;
        while (currentIndex > 1 && num >= heap[currentIndex / 2]) {
            heap[currentIndex] ^= heap[currentIndex / 2];
            heap[currentIndex / 2] ^= heap[currentIndex];
            heap[currentIndex] ^= heap[currentIndex / 2];
            currentIndex /= 2;
        }
    }

    public long pop() {
        long maxValue = remove();
        return maxValue;
    }

    private long remove() {
        long removeNodeValue = heap[1];
        heap[1] = heap[--lastIndex];
        if (lastIndex == 1) {
            return removeNodeValue;
        }

        int currentIndex = 1;
        while (currentIndex < lastIndex) {
            int leftNode = currentIndex * 2;
            int rightNode = currentIndex * 2 + 1;
            if (rightNode < lastIndex && heap[currentIndex] < heap[rightNode]) {
                if (heap[leftNode] >= heap[rightNode]) {
                    heap[currentIndex] ^= heap[leftNode];
                    heap[leftNode] ^= heap[currentIndex];
                    heap[currentIndex] ^= heap[leftNode];
                    currentIndex = leftNode;
                } else {
                    heap[currentIndex] ^= heap[rightNode];
                    heap[rightNode] ^= heap[currentIndex];
                    heap[currentIndex] ^= heap[rightNode];
                    currentIndex = rightNode;
                }
            } else if (leftNode < lastIndex && heap[currentIndex] < heap[leftNode]) {
                heap[currentIndex] ^= heap[leftNode];
                heap[leftNode] ^= heap[currentIndex];
                heap[currentIndex] ^= heap[leftNode];
                currentIndex = leftNode;
            } else {
                break;
            }
        }
        return removeNodeValue;
    }

    public String print() {
        return Arrays.toString(this.heap);
    }

    private void ensureCapacity() {
        heap = Arrays.copyOf(heap, heap.length + CAPACITY_INCREMENT_SIZE);
    }
}
