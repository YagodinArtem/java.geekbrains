package ru.geekbrains.algorithms.lesson2;

public class MySortedArrayList<E extends Comparable<E>> extends MyArrayList<E> {

    @Override
    public void add(E item) {
        int i = 0;
        while (i < size() && item.compareTo(get(i)) >= 0) {
            i++;
        }
        super.add(i, item);
    }

    @Override
    public void add(int index, E item) {
        add(item);
    }

    public int binaryFind(E item) {
        int lo = 0;
        int hi = size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // (hi + lo) / 2;
            if (item.compareTo(get(mid)) < 0) {
                hi = mid - 1;
            } else if (item.compareTo(get(mid)) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
