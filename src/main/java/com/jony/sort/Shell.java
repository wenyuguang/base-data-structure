package com.jony.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class Shell {

    public static void sort(Comparable[] nums){
        int length = nums.length;

        Comparable temp;
        // 每次缩进量为原始长度的一半，一直循环到步长为1
        for (int step = length / 2; step >= 1; step = step / 2) {
            for (int i = step; i < length; i++) {
                temp = nums[i];
                int j = i - step;
                if(j >= 0 && nums[j].compareTo(temp) > 0){
                    nums[j + step] = nums[j];
                    j = j - step;
                }
                nums[j + step] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {32, 52, 123, 12, 67, 23, 87, 64, 98, 54};
        sort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }
}
