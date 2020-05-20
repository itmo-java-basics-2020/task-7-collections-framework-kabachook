package ru.ifmo.collections;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private static final Object VALUE = new Object();
    private final Map<T, Object> storage;

    private SortedSet(Comparator<T> comparator) {
        storage = new TreeMap<>(comparator);
    }

    public static <T> SortedSet<T> create() {
        return from(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<T>(comparator);
    }

    public ArrayList<T> getSorted() {
        return new ArrayList<>(storage.keySet());
    }

    public ArrayList<T> getReversed() {
        var arr = new ArrayList<>(storage.keySet());
        Collections.reverse(arr);
        return arr;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return storage.keySet().removeAll(c);
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return storage.containsKey(o);
    }

    @Override
    public Object[] toArray() {
        return storage.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return storage.keySet().toArray(a);
    }

    @Override
    public boolean add(T t) {
        boolean contains = storage.containsKey(t);
        storage.put(t, VALUE);
        return contains;
    }

    @Override
    public boolean remove(Object o) {
        boolean contains = storage.containsKey(o);
        storage.remove(o);
        return contains;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return storage.keySet().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T el : c) {
            if (add(el)) {
                added = true;
            }
        }
        return added;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return storage.keySet().retainAll(c);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Spliterator<T> spliterator() {
        return storage.keySet().spliterator();
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        return storage.keySet().toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return storage.keySet().removeIf(filter);
    }

    @Override
    public Stream<T> stream() {
        return storage.keySet().stream();
    }

    @Override
    public Stream<T> parallelStream() {
        return storage.keySet().parallelStream();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        storage.keySet().forEach(action);
    }

    @Override
    public Iterator<T> iterator() {
        return storage.keySet().iterator();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
