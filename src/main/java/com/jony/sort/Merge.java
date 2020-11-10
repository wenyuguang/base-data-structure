package com.jony.sort;

import java.util.Arrays;
import java.util.Random;

public class Merge {

    public static void sort(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        // 一个元素时无需排序
        if(left < right){
            // 中间点
            int mid = (left + right) / 2;
            // 递归划分左半区域
            mergeSort(arr, tmp, left, mid);
            // 递归划分右半区域
            mergeSort(arr, tmp, mid + 1, right);
            // 合并
            merge(arr, tmp, left, mid, right);
        }
    }

    // 合并过程
    private static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        // 标记左半块未排序第一个元素
        int leftPos = left;
        

        // 标记右半块未排序第一个元素
        int rightPos = mid + 1;
        // 临时数组的下标指针
        int tmpPos = left;
        // 合并
        while (leftPos <= mid && rightPos <= right){
            // 左半块的数比右边小
            if(arr[leftPos] < arr[rightPos]){
                tmp[leftPos++] = arr[leftPos];
            }else {// 右半块的数比右边小
                tmp[leftPos++] = arr[rightPos];
            }
        }
        // 合并左半块剩余的元素
        while (leftPos <= mid){
            tmp[tmpPos++] = arr[leftPos++];
        }
        // 合并右半块剩余的元素
        while (rightPos <= right){
            tmp[tmpPos++] = arr[rightPos++];
        }
        // 替换原来的数组
        while (left <= right){
            arr[left] = tmp[left];
            left++;
        }
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
