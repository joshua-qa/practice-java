public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {}

    public TreeNode getRoot() {
        return root;
    }

    public int insertNode(int num) {
        if (root == null) {
            root = new TreeNode(num);
            return num;
        }
        return this.insertNode(num, root);
    }

    private int insertNode(int num, TreeNode node) {
        if (node.val >= num) {
            if (node.left == null) {
                node.left = new TreeNode(num);
                return num;
            }
            return insertNode(num, node.left);
        }

        if (node.right == null) {
            node.right = new TreeNode(num);
            return num;
        }
        return insertNode(num, node.right);
    }

    public void deleteNode(int num) {
        root = deleteNodeRec(num, root);
    }

    private TreeNode deleteNodeRec(int num, TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.val != num) {
            if (node.val > num) {
                node.left = deleteNodeRec(num, node.left);
            } else {
                node.right = deleteNodeRec(num, node.right);
            }
        } else {
            // 1 child
            if (node.right == null) {
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }

            // 2 child
            TreeNode t = node;
            node = getMin(node.val, node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private TreeNode getMin(int val, TreeNode node) {
        TreeNode currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}