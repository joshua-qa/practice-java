package Joshua.DS.LL;

public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();

        numbers.addLast(10);
        numbers.addLast(70);
        numbers.addLast(60);
        numbers.addLast(40);
        numbers.addLast(50);
        numbers.addLast(30);
        LinkedList.ListIterator li = numbers.listIterator();
        while(li.hasNext()) {
            if((int)li.next() == 40)
                li.remove();
        }
        System.out.println(numbers);

        DoublyLinkedList Dnumbers = new DoublyLinkedList();

        Dnumbers.addLast(10);
        Dnumbers.addLast(20);
        Dnumbers.addLast(30);
        Dnumbers.addLast(40);
        Dnumbers.addLast(50);

        DoublyLinkedList.ListIterator dli = Dnumbers.listIterator();
        while(dli.hasNext()) {
            if((int)dli.next() == 30)
                dli.remove();
        }

        while(dli.hasPrevious()) {
            if((int)dli.previous() == 10)
                dli.remove();
        }

        System.out.println(Dnumbers);
    }
}
