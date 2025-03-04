package customcollections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomCollectionsTest {

    private CustomArrayList<Integer> intList;
    private CustomArrayList<String> strList;
    private CustomHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        intList = new CustomArrayList<>();
        strList = new CustomArrayList<>();
        map = new CustomHashMap<>();
    }

    @Test
    void testArrayListAddAndGet() {
        intList.add(10);
        intList.add(20);
        assertEquals(10, intList.get(0));
        assertEquals(20, intList.get(1));
    }

    @Test
    void testArrayListAddAtIndex() {
        strList.add("A");
        strList.add("C");
        strList.add(1, "B");
        assertEquals("A", strList.get(0));
        assertEquals("B", strList.get(1));
        assertEquals("C", strList.get(2));
    }

    @Test
    void testArrayListRemove() {
        strList.add("X");
        strList.add("Y");
        strList.remove(0);
        assertEquals("Y", strList.get(0));
        assertEquals(1, strList.size());
    }

    @Test
    void testArrayListSize() {
        assertEquals(0, intList.size());
        intList.add(1);
        intList.add(2);
        assertEquals(2, intList.size());
        intList.remove(1);
        assertEquals(1, intList.size());
    }

    @Test
    void testArrayListClear() {
        intList.add(5);
        intList.add(10);
        intList.clear();
        assertEquals(0, intList.size());
    }

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

    @Test
    void testHashMapPutAndGet() {
        map.put("one", 1);
        assertEquals(1, map.get("one"));
    }

    @Test
    void testHashMapPutOverwrite() {
        map.put("key", 1);
        map.put("key", 2);
        assertEquals(2, map.get("key"));
    }

    @Test
    void testHashMapRemove() {
        map.put("one", 1);
        map.remove("one");
        assertNull(map.get("one"));
    }

    @Test
    void testHashMapGetNonExistentKey() {
        assertNull(map.get("missing"));
    }

    @Test
    void testHashMapSize() {
        assertEquals(0, map.size());
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.size());
        map.remove("one");
        assertEquals(1, map.size());
    }
}
