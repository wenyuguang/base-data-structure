package com.jony.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 */
public class Quick {

    public static void sort(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end){
            return;
        }
        // 对数组进行左右分组区分，分开排序，得到分组索引值
        int pivot = partition(arr, start, end);
        // 对左边子组继续排序，递归
        quickSort(arr, start, pivot - 1);
        // 对右边子组继续排序，递归
        quickSort(arr, pivot + 1, end);

    }
    // 思路为：数组左边两边分别一个指针，左边指针向右移动，右边指针向左移动
    // 分界值默认为起始第一位数
    // 左边往右移动的指针遇到大于分界值的则停止移动
    // 右边往左移动的指针遇到小于分界值的则停止移动
    private static int partition(int[] arr, int start, int end) {
        // 分界值
        int key = arr[start];
        // 左指针
        int left = start;
        // 右指针，指向数组末尾的下一位指针位置
        int right = end + 1;

        while(true){
            // 右边往左移动的指针遇到小于分界值的则停止移动
            while (key < arr[--right]){
                if (right == start){
                    break;
                }
            }
            // 左边往右移动的指针遇到大于分界值的则停止移动
            while (key > arr[++left]){
                if (left == end){
                    break;
                }
            }
            // left>=right 停止 否则交换数
            if (left >= right){
                break;
            }else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // 需要交换确定的分界值
        int tmp = arr[start];
        arr[start] = arr[right];
        arr[right] = tmp;

        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(nums));
        sort(nums);

        System.out.println(Arrays.toString(nums));

    }
}
