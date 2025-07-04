import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int size;

    public LRUCache(int size) {
        super(size, 0.75f, true); // accessOrder = true
        this.size = size;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> e) {
        return size() > size;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1); // use key 1
        cache.put(4, "D"); // evicts 2
        cache.get(3); // use key 3
        cache.put(5, "E"); // evicts 1
        System.out.println(cache); // {4=D, 3=C, 5=E}
    }
}
