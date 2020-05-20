package ru.ifmo.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private Set<Integer> seen = new HashSet<>();
    private Set<Integer> uniq = new LinkedHashSet<>();


    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            this.add(number);
        }
    }

    public int showFirstUnique() {
        return uniq.isEmpty() ? -1 : uniq.iterator().next();
    }

    public void add(int value) {
        if (!seen.contains(value)) {
            uniq.add(value);
        } else {
            uniq.remove(value);
        }
        seen.add(value);

    }
}
