package customcollections;

/**
 * Собственная реализация HashMap.
 * @param <K> тип ключей
 * @param <V> тип значений
 */
public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;
    private int size;

    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % table.length);                        // Предотвращаем отрицательные индексы
        Entry<K, V> newEntry = new Entry<>(key, value);
        
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) { 
                    current.value = value;                                          // Обновляем значение, если ключ уже есть
                    return;
                }
                if (current.next == null) {                                         // Проверяем последний узел перед добавлением
                    break;
                }
                current = current.next;
            }
            current.next = newEntry;                                                // Добавляем новый узел
        }
        size++;
    }    

    public V get(K key) {
        int index = key.hashCode() % table.length;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = key.hashCode() % table.length;
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public int size() {
        return size;
    }
}
