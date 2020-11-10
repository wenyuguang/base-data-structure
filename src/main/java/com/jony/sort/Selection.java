package com.jony.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selection {

    public static void sort(Integer[] nums){
        // 第一轮比较N - 1次
        for (int i = 0; i < nums.length - 1; i++) {
            // 最小值的索引
            Integer min = i;
            // 第二轮比较 N - i次，当发现最小索引位置时，更新最小值的索引
            for (int j = i + 1; j < nums.length; j++) {
                // 发现还有比当前索引i小的数，更新最小索引值
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            // 内部循环查找最小值的索引完毕后，判断是否有更新最小值的索引，有更新则直接替换数组内的值
            if(i != min){
                Integer temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {32, 52, 123, 12, 67, 23, 87, 64, 98, 54};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
