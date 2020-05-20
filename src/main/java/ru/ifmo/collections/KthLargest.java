package ru.ifmo.collections;

import java.util.TreeSet;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private int k;
    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    private TreeSet<Integer> storage = new TreeSet<>((left, right) -> {
        int result = Integer.compare(left, right);
        if (result == 0) {
            return -1;
        } else {
            return result;
        }
    });

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        for (int number : numbers) {
            this.add(number);
        }
    }

    public int add(int val) {
        storage.add(val);
        return storage
                .descendingSet()
                .stream()
                .skip(this.k - 1)
                .findFirst()
                .orElse(-1);
    }
}