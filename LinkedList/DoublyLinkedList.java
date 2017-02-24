package Joshua.DS.LL;

/**
 * Created by Joshua on 2017-02-24.
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        private Object data;

        private Node next;
        private Node prev;
        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        Node firstNode = new Node(input);
        firstNode.next = head;

        if (head != null) {
            head.prev = firstNode;
        }

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
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    Node node(int index) {
        if (index < size / 2) {
            Node x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public void addNode(Object input, int index) {
        Node newNode = new Node(input);
        Node currentNode = node(index-1);
        Node tempNode = currentNode.next;

        currentNode.next = newNode;
        newNode.next = tempNode;

        if(tempNode != null) {
            tempNode.prev = newNode;
        }

        newNode.prev = currentNode;

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

        if(temp.next != null) {
            temp.next.prev = temp;
        }

        Object returnData = currentNode.data;
        currentNode = null;
        size--;
        return returnData;
    }

    public Object removeLast() {
        return removeNode(size - 1);
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

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public Object previous() {
            if (next == null) {
                lastReturned = next = tail;
            } else {
                lastReturned = next;
                next = next.prev;
            }
            nextIndex--;
            return lastReturned.data;
        }

        public void add(Object input) {
            Node newNode = new Node(input);
            if(lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if (next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
                }
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }

        public void remove() {
            if(nextIndex == 0) {
                throw new IllegalStateException();
            }
            Node n = lastReturned.next;
            Node p = lastReturned.prev;

            if (p == null) {
                head = n;
                head.prev = null;
                lastReturned = null;
            } else {
                p.next = next;
                lastReturned.prev = null;
            }

            if (n == null) {
                tail = p;
                tail.next = null;
            } else {
                n.prev = p;
            }

            if (next == null) {
                lastReturned = tail;
            } else {
                lastReturned = next.prev;
            }

            size--;
            nextIndex--;
        }
    }
}
