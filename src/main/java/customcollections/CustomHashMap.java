package customcollections;

/**
 * Собственная реализация HashMap.
 * @param <K> тип ключей
 * @param <V> тип значений
 */
public class CustomHashMap<K, V> {
    /**
     * Внутренний класс для представления узлов (пар ключ-значение) в таблице.
     */
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        /**
         * Создает новую запись с указанным ключом и значением.
         * @param key   ключ
         * @param value значение
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;                                 // Начальный размер таблицы
    private Entry<K, V>[] table;                                                    // Таблица хранения элементов
    private int size;                                                               // Количество элементов в карте
    /**
     * Конструктор, создающий пустую HashMap с начальной емкостью.
     */
    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }
    /**
     * Добавляет новую пару ключ-значение в карту. Если ключ уже существует, обновляет его значение.
     * @param key   ключ
     * @param value значение
     */
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode() % table.length);                        // Вычисление индекса
        Entry<K, V> newEntry = new Entry<>(key, value);
        
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) { 
                    current.value = value;                                          // Обновление значения, если ключ уже существует
                    return;
                }
                if (current.next == null) {                                         // Проверка последнего узла перед добавлением
                    break;
                }
                current = current.next;
            }
            current.next = newEntry;                                                // Добавление нового узла в цепочку
        }
        size++;
    }    
    /**
     * Получает значение по ключу.
     * @param key ключ
     * @return значение, связанное с ключом, или null, если ключ не найден
     */
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
    /**
     * Удаляет элемент с указанным ключом из карты.
     * @param key ключ, который нужно удалить
     */
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

    /**
     * Возвращает количество элементов в карте.
     * @return размер карты
     */
    public int size() {
        return size;
    }
}
