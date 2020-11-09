package com.jony.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {

    // 有两层循环，当内部循环发生交换时，不需要再次交换了
    // 每排序一次就确定了一个数在最前或者最后，减少一次循环
    public static void sort(Comparable[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            // 与插入排序区别在于：插入排序继续循环外部循环i次，冒泡则是循环外部已经循环过后的次数，因为排序好的数不需要再次排序
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j].compareTo(nums[j + 1]) > 0){
                    Comparable temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {32, 32, 52, 123, 12, 67, 23, 87, 64, 98, 54};
        sort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
