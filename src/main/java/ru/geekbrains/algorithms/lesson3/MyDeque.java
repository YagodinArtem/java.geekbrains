package ru.geekbrains.algorithms.lesson3;

public class MyDeque<T> extends MyQueue{



    public MyDeque(int capacity) {
        super(capacity);
    }

    public MyDeque() {
        super();
    }

    /**
     * @param item вставляется в конец деки
     */
    @Override
    public void insert(Object item) {
        super.insert(item);
    }

    /**
     * @param item вставляется в начало деки
     */
    public void insertBegin(Object item) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        setSize(getSize() + 1);
        getList()[previousIndex(getBegin())] = item;
        setBegin(previousIndex(getBegin()));
    }

    /**
     * <T> удаляется и возвращается из начала деки
     */
    @Override
    public Object remove() {
        return super.remove();
    }

    /**
     * <T> удаляется и возвращается из конца деки
     */
    public T removeEnd() {
        T temp = (T) peekEnd();
        setSize(getSize() - 1);
        getList()[previousIndex(getEnd())] = null;
        setEnd(previousIndex(getEnd()));
        return temp;
    }

    @Override
    public Object peek() {
        return super.peek();
    }

    @Override
    public boolean isFull() {
        return super.isFull();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
