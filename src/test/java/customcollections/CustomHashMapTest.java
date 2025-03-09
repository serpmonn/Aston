package customcollections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тесты для CustomHashMap.
 */
class CustomHashMapTest {

    private CustomHashMap<String, Integer> map;
    private CustomHashMap<Integer, String> intMap;

    @BeforeEach
    void setUp() {
        map = new CustomHashMap<>();
        intMap = new CustomHashMap<>();
    }
    /**
     * Проверка добавления и получения значений в CustomHashMap.
     */
    @Test
    void testPutAndGet() {
        map.put("one", 1);
        assertEquals(1, map.get("one"));
    }
    /**
     * Проверка перезаписи значения в CustomHashMap.
     */
    @Test
    void testPutOverwrite() {
        map.put("key", 1);
        map.put("key", 2);
        assertEquals(2, map.get("key"));
    }
    /**
     * Проверка удаления элемента из CustomHashMap.
     */
    @Test
    void testRemove() {
        map.put("one", 1);
        map.remove("one");
        assertNull(map.get("one"));
    }
    /**
     * Проверка запроса несуществующего ключа в CustomHashMap.
     */
    @Test
    void testGetNonExistentKey() {
        assertNull(map.get("missing"));
    }
    /**
     * Проверка подсчета размера CustomHashMap.
     */
    @Test
    void testSize() {
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
    void testLargeNumberOfOperations() {
        for (int i = 0; i < 1000; i++) {
            intMap.put(i, "Value" + i);
        }

        for (int i = 0; i < 1000; i++) {
            assertEquals("Value" + i, intMap.get(i));
        }

        for (int i = 0; i < 1000; i++) {
            intMap.remove(i);
        }

        for (int i = 0; i < 1000; i++) {
            assertNull(intMap.get(i));
        }
    }
}
