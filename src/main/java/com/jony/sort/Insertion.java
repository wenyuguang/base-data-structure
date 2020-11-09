package com.jony.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insertion {

    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(greater(a[j - 1], a[j])){
                    exchange(a, j - 1, j);
                }
            }
        }
    }

    private static boolean greater(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    private static void exchange(Comparable[] a, int b, int c){
        Comparable temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    public static void main(String[] args) {
        Integer[] nums = {32, 52, 123, 12, 67, 23, 87, 64, 98, 54};
//        sort(nums);

//        Arrays.stream(nums).forEach(System.out::println);


        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= i; j ++) {
                if(nums[j - 1].compareTo(nums[j]) > 0){
                    Integer temp = nums[ j - 1];
                    nums[ j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
