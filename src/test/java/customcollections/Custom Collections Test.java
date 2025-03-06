package customcollections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Тесты для классов CustomArrayList и CustomHashMap.
 */
class CustomCollectionsTest {

    private CustomArrayList<Integer> intList;
    private CustomArrayList<String> strList;
    private CustomHashMap<String, Integer> map;
    private CustomHashMap<Integer, String> intMap;
    /**
     * Инициализация перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        intList = new CustomArrayList<>();
        strList = new CustomArrayList<>();
        map = new CustomHashMap<>();
        intMap = new CustomHashMap<>();
    }
    /**
     * Проверка добавления и получения элементов в CustomArrayList.
     */
    @Test
    void testArrayListAddAndGet() {
        intList.add(10);
        intList.add(20);
        assertEquals(10, intList.get(0));
        assertEquals(20, intList.get(1));
    }
    /**
     * Проверка добавления элемента по индексу в CustomArrayList.
     */
    @Test
    void testArrayListAddAtIndex() {
        strList.add("A");
        strList.add("C");
        strList.add(1, "B");
        assertEquals("A", strList.get(0));
        assertEquals("B", strList.get(1));
        assertEquals("C", strList.get(2));
    }
    /**
     * Проверка удаления элемента из CustomArrayList.
     */
    @Test
    void testArrayListRemove() {
        strList.add("X");
        strList.add("Y");
        strList.remove(0);
        assertEquals("Y", strList.get(0));
        assertEquals(1, strList.size());
    }
    /**
     * Проверка корректного подсчета размера CustomArrayList.
     */
    @Test
    void testArrayListSize() {
        assertEquals(0, intList.size());
        intList.add(1);
        intList.add(2);
        assertEquals(2, intList.size());
        intList.remove(1);
        assertEquals(1, intList.size());
    }
    /**
     * Проверка очистки CustomArrayList.
     */
    @Test
    void testArrayListClear() {
        intList.add(5);
        intList.add(10);
        intList.clear();
        assertEquals(0, intList.size());
    }
    /**
     * Проверка сортировки CustomArrayList с использованием quickSort.
     */
    @Test
    void testArrayListQuickSort() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.quickSort();
        assertEquals(1, intList.get(0));
        assertEquals(2, intList.get(1));
        assertEquals(3, intList.get(2));
    }
    /**
     * Проверка добавления и получения значений в CustomHashMap.
     */
    @Test
    void testHashMapPutAndGet() {
        map.put("one", 1);
        assertEquals(1, map.get("one"));
    }
    /**
     * Проверка перезаписи значения в CustomHashMap.
     */
    @Test
    void testHashMapPutOverwrite() {
        map.put("key", 1);
        map.put("key", 2);
        assertEquals(2, map.get("key"));
    }
    /**
     * Проверка удаления элемента из CustomHashMap.
     */
    @Test
    void testHashMapRemove() {
        map.put("one", 1);
        map.remove("one");
        assertNull(map.get("one"));
    }
    /**
     * Проверка запроса несуществующего ключа в CustomHashMap.
     */
    @Test
    void testHashMapGetNonExistentKey() {
        assertNull(map.get("missing"));
    }
    /**
     * Проверка подсчета размера CustomHashMap.
     */
    @Test
    void testHashMapSize() {
        assertEquals(0, map.size());
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.size());
        map.remove("one");
        assertEquals(1, map.size());
    }
    /**
     * Проверка подсчета размера CustomHashMap.
     */
    @Test
    void testHashMapLargeNumberOfOperations() {
        // Добавляем 1000 элементов
        for (int i = 0; i < 1000; i++) {
            intMap.put(i, "Value" + i);
        }

        // Проверяем, что все добавленные элементы присутствуют
        for (int i = 0; i < 1000; i++) {
            assertEquals("Value" + i, intMap.get(i));
        }

        // Удаляем 1000 элементов
        for (int i = 0; i < 1000; i++) {
            intMap.remove(i);
        }

        // Проверяем, что элементы больше не существуют
        for (int i = 0; i < 1000; i++) {
            assertNull(intMap.get(i));
        }
    }
}
