package Joshua.DS.HashTable;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class HashTable {
    final int TABLE_SIZE = 1009;
    LinkedList<Pair>[] hashTable;

    public HashTable() {
        hashTable = new LinkedList[TABLE_SIZE];
    }

    public void put(String k, int v) {
        int key = hashing(k);
        Pair pair = new Pair(k, v);

        if(hashTable[key] == null) {
            hashTable[key] = new LinkedList<>();
            hashTable[key].addFirst(pair);
        } else {
            hashTable[key].addFirst(pair);
        }
    }

    public Integer get(String key) {
        if(!containsKey(key)) {
            return null;
        }

        for(Pair pair : hashTable[hashing(key)]) {
            if(pair.key.equals(key)) {
                return pair.value;
            }
        }

        return null;
    }

    public boolean remove(String key) {
        if(!containsKey(key)) {
            return false;
        }
        int hashKey = hashing(key);

        for(Pair pair : hashTable[hashKey]) {
            if(pair.key.equals(key)) {
                hashTable[hashKey].remove();
                return true;
            }
        }

        return false;
    }

    private boolean containsKey(String key) {
        int hashKey = hashing(key);
        if(hashTable[hashKey] == null) {
            return false;
        }

        for(Pair pair : hashTable[hashKey]) {
            if(pair.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    private int hashing(String key) {
        int hashValue = 0;
        char[] keyChars = key.toCharArray();

        for(char ch : keyChars) {
            hashValue += ch;
        }

        return hashValue % TABLE_SIZE;
    }
}