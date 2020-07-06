package 穆帆.LRU;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/7/6
 */
public class LRUCache {
    private int capacity;
    LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(Integer key) {
        if (linkedHashMap.containsKey(key)) {
            Integer value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(Integer key, Integer value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
        } else if (linkedHashMap.size() >= capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = linkedHashMap.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        linkedHashMap.put(key, value);
    }
}
