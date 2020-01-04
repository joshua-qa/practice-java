public class SegmentTree {
    private int[] tree;
    private int[] nums = new int[1 << 5];
    public static final int TREE_SIZE = 1 << 6;
    public static final int POWER = 6;
    public static final int MAX = Integer.MAX_VALUE;

    public void run() {
        tree = new int[TREE_SIZE];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        init();
        update(24, 5);
        System.out.println(query(17, 32));
        String result = print();
        System.out.println(result);
    }

    private String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 1; i < POWER; i++) {
            for (int k = 0; k < (1 << i); k++, j++) {
                sb.append(tree[j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void init() {
        for (int i = TREE_SIZE / 2, j = 0; i < TREE_SIZE; i++, j++) {
            tree[i] = nums[j];
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
        }
    }

    private int query(int startIndex, int endIndex) {
        return search(startIndex, endIndex, 1, 1, nums.length);
    }

    private int search(int left, int right, int node, int nodeStart, int nodeEnd) {
        if (left > nodeEnd || right < nodeStart) {
            return MAX;
        }
        if (left <= nodeStart && right >= nodeEnd) {
            return tree[node];
        }
        int mid = (nodeStart + nodeEnd) / 2;
        System.out.println("ns : " + nodeStart + ", ne : " + nodeEnd + ", mid : " + mid);
        return Math.min(search(left, right, node*2, nodeStart, mid), search(left, right, node*2+1, mid+1, nodeEnd));
    }

    private void update(int index, int num) {
        int n = nums.length + index - 1;
        tree[n] = num;

        while (n > 0) {
            n /= 2;
            tree[n] = Math.min(tree[n*2], tree[n*2+1]);
        }
    }
}
