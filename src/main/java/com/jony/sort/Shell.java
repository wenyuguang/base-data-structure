package com.jony.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 */
public class Shell {

    /**
     * 教程里面的
     * @param nums
     */
    public static void sort(Comparable[] nums){
        int length = nums.length;

        Comparable temp;
        // 每次缩进量为原始长度的一半，一直循环到步长为1
        for (int step = length / 2; step >= 1; step = step / 2) {
            // 从缩进量（数组的中间）开始一直往数组后面走
            for (int i = step; i < length; i++) {
                // 临时保存索引i对应的值，会拿去和i-step进行比较
                temp = nums[i];
                // 往前比较（雷同插入排序，只是存在缩进量间隔，插入排序缩进量间隔为1）
                int j = i - step;
                while(j >= 0 && nums[j].compareTo(temp) > 0){
                    // 当前缩进量对应的数大于往前推的数，需要交换数
                    // j + step 也就是 i
                    nums[j + step] = nums[j];
                    // 继续往前推移step
                    j = j - step;
                }
                // j + step 也就是 i
                nums[j + step] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        Integer[] nums = {32, 52, 123, 12, 67, 23, 87, 64, 98, 54};
//        sort(nums);
        int[] nums = new int[100];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(2000);
        }


        /**
         * 这个版本比较容易懂
         */
        // 轮询缩进量，一直到缩进量为1
        for (int step = nums.length / 2; step >= 1; step = step / 2) {
            // 从缩进量位置往后遍历
            for (int i = step; i < nums.length; i++) {
                // 根据缩进量往前遍历
                for (int j = i; j >= step ; j = j - step) {
                    // 发现前面比当前索引位置数大的进行交换操作
                    if(nums[j - step] > nums[j]){
                        int tmp = nums[j - step];
                        nums[j - step] = nums[j];
                        nums[j] = tmp;
                    }else {
                        break;
                    }
                }
            }
        }

        Arrays.stream(nums).forEach(System.out::println);
    }
}
