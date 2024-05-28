import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private static final int SIZE = 1000;
    private List<List<Pair>> map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            map.add(null);
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % SIZE;
        List<Pair> pairs = map.get(index);
        if (pairs == null) {
            pairs = new ArrayList<>();
            map.set(index, pairs);
        }
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        pairs.add(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % SIZE;
        List<Pair> pairs = map.get(index);
        if (pairs == null) return -1;
        for (Pair pair : pairs) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % SIZE;
        List<Pair> pairs = map.get(index);
        if (pairs == null) return;
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pairs.remove(pair);
                return;
            }
        }
    }

    private static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

// Test
public class Main {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1)); // Output: 1
        System.out.println(obj.get(3)); // Output: -1
        obj.put(2, 1);
        System.out.println(obj.get(2)); // Output: 1
        obj.remove(2);
        System.out.println(obj.get(2)); // Output: -1
    }
}
