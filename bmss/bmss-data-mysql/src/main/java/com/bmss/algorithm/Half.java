package com.bmss.algorithm;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Created by fengxuan1 on 2017/4/17.
 */
public class Half {

    public static int getNumByHalf(List<Integer> integers, int target){
        int place = 0;
        int begin = 0;
        int end = integers.size();
        Collections.sort(integers);

        while (end > begin){
            int mid = (begin + end) / 2;
            Integer integer = integers.get(mid);
            if(target > integer){
                begin = mid + 1;
            }else if(target < integer) {
                end = mid - 1;
            }else {
                place = mid;
                return place;
            }
        }
        return 0;
    }



    public static int getArraysByFastSort(int[] integers, int left, int right){
        int povit = integers[left];
        while (left < right){
            while (left < right && povit < integers[right]){
                right--;
            }
            // 将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivotkey大的数补上
            integers[left] = integers[right];
            while (left < right && integers[left] <= povit) {
                ++left;
            }
            // 将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivotkey小的数补上
            integers[right] = integers[left];
        }
        // 当left == right，完成一趟快速排序，此时left位相当于空，等待pivotkey补上
        integers[left] = povit;
        return left;
    }


    public static void quickSort(int[] array, int left, int right) {
        int pivotKey;
        if (left < right) {
            pivotKey = getArraysByFastSort(array, left, right);
            // 对左右数组递归调用快速排序，直到顺序完全正确
            quickSort(array, left, pivotKey - 1);
            quickSort(array, pivotKey + 1, right);
        }
    }



    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 4, 2, 9, 11, 90, 56, 45, 67);

        int[] arrays = {1, 4, 2, 9, 11, 90, 56, 45, 67};
//        int numByHalf = getNumByHalf(list, 67);
//        System.out.println(numByHalf);
//
//
//        Collections.sort(list);
//        System.out.println(list.get(numByHalf));

        quickSort(arrays, 0, arrays.length - 1);
        for (int i: arrays){
            System.out.println(i);
        }
    }
}
