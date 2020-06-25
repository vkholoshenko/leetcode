package lc380_InsertDeleteRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    private final ArrayList<Integer> storage;
    private final Map<Integer, Integer> index;
    private final Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.storage = new ArrayList<>();
        this.index = new HashMap<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!this.index.containsKey(val)) {
            this.index.put(val, storage.size());
            this.storage.add(val);
            return true;
        } else  {
            return false;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (index.containsKey(val)) {
            int indexToRemove = index.get(val);
            int valueToShift = storage.get(storage.size()-1);
            storage.set(indexToRemove, valueToShift);
            index.put(valueToShift, indexToRemove);
            storage.remove(storage.size()-1);
            index.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return storage.get(random.nextInt(storage.size()));

    }
}

