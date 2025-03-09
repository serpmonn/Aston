package customcollections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Тесты для CustomArrayList.
 */
class CustomArrayListTest {

    private CustomArrayList<Integer> intList;
    private CustomArrayList<String> strList;
    /**
     * Инициализация перед каждым тестом.
     */
    @BeforeEach
    void setUp() {
        intList = new CustomArrayList<>();
        strList = new CustomArrayList<>();
    }
    /**
     * Проверка добавления и получения элементов в CustomArrayList.
     */
    @Test
    void testAddAndGet() {
        intList.add(10);
        intList.add(20);
        assertEquals(10, intList.get(0));
        assertEquals(20, intList.get(1));
    }
    /**
     * Проверка добавления элемента по индексу в CustomArrayList.
     */
    @Test
    void testAddAtIndex() {
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
    void testRemove() {
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
    void testSize() {
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
    void testClear() {
        intList.add(5);
        intList.add(10);
        intList.clear();
        assertEquals(0, intList.size());
    }
    /**
     * Проверка сортировки CustomArrayList с использованием quickSort.
     */
    @Test
    void testQuickSort() {
        intList.add(3);
        intList.add(1);
        intList.add(2);
        intList.quickSort();
        assertEquals(1, intList.get(0));
        assertEquals(2, intList.get(1));
        assertEquals(3, intList.get(2));
    }
}
