package com.jony.heap;

/**
 * 堆
 */
public class Heap<T extends Comparable<T>> {

    private T[] data;
    private int size;

    public Heap(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public void insert(T t){
        data[++size] = t;
        swim(size);
    }

    public T deleteMax(){
        // 最大堆第一个为最大
        T max = data[1];
        // 交换最大和最小值
        data[1] = data[size];
        data[size] = null;
        size --;
        sink(1);
        return max;
    }

    /**
     * 下沉算法，使元素在合理的位置
     * @param index
     */
    private void sink(int index) {

        while (2 * index < size){
            // 找到子节点中较大的节点
            int max;
            // 存在右子节点
            if (2 * index + 1 <= size){
                if (data[2 * index].compareTo(data[2 * index + 1]) < 0){
                    max = 2 * index + 1;
                }else {
                    max = 2 * index;
                }
            }else {
                // 不存在右子节点
                max = 2 * index;
            }
            if (max < size){
                break;
            }
            T tmp = data[index];
            data[index] = data[max];
            data[max] = tmp;
            index = max;
        }
    }

    /**
     * 上浮算法，使元素在合理的位置
     * @param index
     */
    private void swim(int index) {
        // 根节点不需要循环了
        while (index > 1){
            // 比较当前节点和父节点的大小
            if (data[index / 2].compareTo(data[index]) < 0){
                T tmp = data[index / 2];
                data[index / 2] = data[index];
                data[index] = tmp;
            }
            index = index / 2;
        }
    }
}
