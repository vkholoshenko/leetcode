package test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertHelper<T> {
    public void assertSetEquals(List<T> c1, List<T> c2) {
        HashSet<T> set1 = new HashSet<>(c1);
        HashSet<T> set2 = new HashSet<>(c2);
        String msg = set1.toString() + " != " + set2.toString();
        assertEquals(set1.size(), set2.size(), msg);
        for (T item : set1) {
            assertTrue(set2.contains(item), msg);
        }
    }
}
