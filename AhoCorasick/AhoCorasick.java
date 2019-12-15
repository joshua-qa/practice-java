import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class AhoCorasick {

    public void run() {
        Node trie = new Node(true);
//        trie.insertNode("he");
//        trie.insertNode("hers");
//        trie.insertNode("his");
//        trie.insertNode("she");
//        trie.insertNode("a");
//        trie.insertNode("ab");
//        trie.insertNode("acd");
//        trie.insertNode("c");
        trie.insertNode("a");
        trie.insertNode("ab");
        trie.insertNode("ac");
        trie.insertNode("adab");
        trie.insertNode("adada");

        Queue<Node> queue = new LinkedList<>();

        queue.offer(trie);
        System.out.println(trie);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            Node[] nodes = curr.getNodes();
            for (int i = 0; i < Node.MAX_NODE; i++) {
                Node node = nodes[i];
                if (Objects.isNull(node)) {
                    continue;
                }
                // dest가 curr이면 스킵
                if (curr.isRoot()) {
                    node.setFailureLink(curr);
                }
                Node dest = curr;
                while (!Objects.isNull(dest.getFailureLink())) {
                    Node fail = dest.getFailureLink();
                    if (fail.isExist(i)) {
                        node.setFailureLink(fail.getChildNode(i));
                        break;
                    } else {
                        if (fail.isRoot()) {
                            node.setFailureLink(fail);
                            break;
                        }
                        dest = fail;
                    }
                }
                if (node.isOutput()) {
                    node.setOutputLink(node);
                } else {
                    node.setOutputLink(node.getFailureLink().getOutputLink());
                }

                queue.offer(node);
            }
        }

        queue.offer(trie);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            Node[] nodes = curr.getNodes();
            for (int i = 0; i < Node.MAX_NODE; i++) {
                Node node = nodes[i];
                if (Objects.isNull(node)) {
                    continue;
                }
                System.out.print((char)(i + 'a'));
                System.out.print(" " + node);
                System.out.print(" " + node.getFailureLink());
                System.out.println(" " + node.getOutputLink());
                queue.offer(node);
            }
        }

        match(trie, "adadac");
    }

    private void match(Node trie, String str) {
        int strIndex = 0;
        int strLength = str.length();

        Node curr = trie;
        while (strIndex < strLength) {
            int c = str.charAt(strIndex) - 'a';

            while (!curr.isRoot() && !curr.isExist(c)) {
                curr = curr.getFailureLink();
            }
            if (curr.isExist(c)) {
                curr = curr.getChildNode(c);
                if (curr.isOutput()) {
                    System.out.println(str.charAt(strIndex) + " match");
                }
            }

            strIndex++;
        }
    }
}

class Node {
    public static final int MAX_NODE = 26;
    private Node[] node;
    private Node failureLink, outputLink;
    private boolean isRoot, isOutput;

    public Node() {
        this.node = new Node[MAX_NODE];
    }

    public Node(boolean isRoot) {
        this.node = new Node[MAX_NODE];
        this.isRoot = isRoot;
    }

    public void insertNode(String str) {
        insert(str.toCharArray(), 0);
    }

    private void insert(char[] str, int index) {
        if (index == str.length) {
            this.isOutput = true;
            return;
        }
        int nodeIndex = str[index] - 'a';
        if (Objects.isNull(this.node[nodeIndex])) {
            this.node[nodeIndex] = new Node();
        }

        this.node[nodeIndex].insert(str, index+1);
    }

    public boolean isExist(int index) {
        return !Objects.isNull(this.node[index]);
    }

    public Node[] getNodes() {
        return node;
    }

    public Node getChildNode(int index) {
        return this.node[index];
    }

    public Node getFailureLink() {
        return failureLink;
    }

    public void setFailureLink(Node failureLink) {
        this.failureLink = failureLink;
    }

    public Node getOutputLink() {
        return outputLink;
    }

    public void setOutputLink(Node outputLink) {
        this.outputLink = outputLink;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public boolean isOutput() {
        return isOutput;
    }

    public void setOutput(boolean output) {
        isOutput = output;
    }
}