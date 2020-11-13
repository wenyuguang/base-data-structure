package com.jony.linear;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 顺序表
 */
public class SequenceList<T> implements Iterable<T>{

    private T[] elements;
    private int size;

    public SequenceList(int capacity) {
        elements = (T[]) new Object[capacity];
        size = 0;
    }

    public void clear(){
        size = 0;
        elements = (T[]) new Object[elements.length];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int length(){
        return size;
    }

    public T get(int i){
        if (i < 0 || i >= size){
            throw new RuntimeException("当前元素不存在！");
        }
        return elements[i];
    }

    public void insert(int i, T t){
        if (i < 0 || i >= size){
            throw new RuntimeException("索引值大于等于零，且索引值不能大于" + size);
        }

        for (int j = size; j < i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = t;
        size ++;
    }

    public void insert(T t){
        if(size == elements.length){
            throw new RuntimeException("表满了");
        }
        elements[size ++] = t;
        size ++;
    }

    public T remove(int i){

        if (i<0 || i> size - 1){
            throw new RuntimeException("当前要删除的元素不存在");
        }
        T element = elements[i];
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        size --;
        return element;
    }

    public int indexOf(T t){
        if(t == null){
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < size - 1; i++) {
            if(elements[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequenceList<String> sl = new SequenceList<>(10);
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");
        //测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是：" + removeResult);
        //测试清空
//        sl.clear();
//        System.out.println("清空后的线性表中的元素个数为:" + sl.length());

        for (int i = 0; i < sl.length(); i++) {
            System.out.println(sl.get(i));
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int current;

        public SIterator() {
            this.current = 0;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Object next() {
            return elements[current ++];
        }
    }
}
