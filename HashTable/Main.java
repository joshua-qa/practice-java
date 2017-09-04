package Joshua.DS.HashTable;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        HashTable hashTable = new HashTable();

        hashTable.put("test", 1234);
        hashTable.put("tdtt", 4321);
        hashTable.put("Joshua", 28);

        System.out.println(hashTable.get("1234"));
        System.out.println(hashTable.get("test"));
        System.out.println(hashTable.get("tdtt"));
    }
}
