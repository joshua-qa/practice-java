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
    }
}
