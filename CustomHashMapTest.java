package customcollections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CustomHashMapTest {
    @Test
    void testPutAndGet() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        assertEquals(1, map.get("one"));
    }

    @Test
    void testRemove() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.remove("one");
        assertNull(map.get("one"));
    }
}
