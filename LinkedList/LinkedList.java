package Joshua.DS.LL;

/**
 * Created by Joshua on 2017-02-24.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data;

        private Node next;
        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node firstNode = new Node(input);
        firstNode.next = head;
        head = firstNode;

        size++;
        if(head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        Node newNode = new Node(input);

        if(size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void addNode(Object input, int index) {
        Node newNode = new Node(input);
        Node currentNode = node(index-1);
        Node tempNode = currentNode.next;

        currentNode.next = newNode;
        newNode.next = tempNode;

        size++;
        if(newNode.next == null) {
            tail = newNode;
        }
    }

    public String toString() {
        if(head == null) {
            return "[]";
        }

        Node temp = head;
        String str = "[";

        while(temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }

        str += temp.data;
        return str+"]";
    }

    public Object removeFirst() {
        Node temp = head;

        head = temp.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object removeNode(int index) {
        if (index == 0) {
            return removeFirst();
        }

        Node temp = node(index-1);
        Node currentNode = temp.next;
        temp.next = currentNode.next;

        Object returnData = currentNode.data;
        currentNode = null;
        size--;
        return returnData;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node temp = node(index);
        return temp.data;
    }

    public int indexOf(Object data) {
        Node temp = head;

        int index = 0;

        while(temp.data != data) {
            temp = temp.next;
            index++;

            if(temp == null) {
                return -1;
            }
        }

        return index;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    public class ListIterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;

        ListIterator() {
            next = head;
            nextIndex = 0;
        }

        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input) {
            Node newNode = new Node(input);
            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if(nextIndex == 0) {
                throw new IllegalStateException();
            }
            LinkedList.this.removeNode(nextIndex-1);
            nextIndex--;
        }
    }
}