package lc380_InsertDeleteRandom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedSetTest {

    @Test
    void test() {
        RandomizedSet set = new RandomizedSet();
        set.insert(0);
        set.insert(1);
        set.remove(0);
        set.insert(2);
        set.remove(1);
        assertEquals(2, set.getRandom());
    }
}