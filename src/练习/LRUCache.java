package 练习;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author mufan
 * @date 2020/5/25
 */
public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsValue(key)) {
            map.remove(key);
        } else if (map.size() >= capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}
