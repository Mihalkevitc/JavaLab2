package lab3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SynchronizedMap<K, V> implements Map<K, V>
{
    private final Map<K, V> map = new HashMap<>();

    @Override
    public synchronized int size()
    {
        return map.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public synchronized boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public synchronized boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public synchronized V get(Object key) {
        return map.get(key);
    }

    @Override
    public synchronized V put(K key, V value) {
        return null;
    }

    @Override
    public synchronized V remove(Object key) {
        return null;
    }

    @Override
    public synchronized void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public synchronized void clear() {

    }

    @Override
    public synchronized Set<K> keySet() {
        return null;
    }

    @Override
    public synchronized Collection<V> values() {
        return null;
    }

    @Override
    public synchronized Set<Entry<K, V>> entrySet() {
        return null;
    }

}
