package com.bmss.LocalThreadDemos;

/**
 * Created by fengxuan1 on 2017/1/17.
 */
public class FindMissingNum {


    public int findMissing(int[] nums){
        int size = nums.length;
        int numbers = 0;
        for (int i = 0; i < size; i++) {
            numbers ^= (i + 1) ^ nums[i];
        }
        numbers ^= (size + 1);
        return numbers;
    }


    public int[] findTwoMissing(int[] nums){
        int size = nums.length;
        int numbers = 0;
        int miss1 = 0;
        int miss2 = 0;
        for (int i = 0; i < size; i++) {
            numbers ^= (i + 1) ^ nums[i];
        }
        numbers ^= (size + 1);
        numbers ^= (size + 2);
        int theLowest2InNumbers = numbers - (numbers & (numbers -1));
        for (int i = 0; i < size; i++) {
//            if((i + 1)&theLowest2InNumbers)
//                miss1 ^= (i + 1);
        }


        return new int[]{miss1, miss2};

    }

    public static void main(String[] args) {
        int[] nums = {10, 12, 11, 1, 6, 7, 9, 2, 4, 3, 5};
        FindMissingNum findMissingNum = new FindMissingNum();
        int result = findMissingNum.findMissing(nums);
        System.out.println("result: " + result);

        System.out.println("======" +  (7 ^ 9));



        int m = 7 ^ 9;
        int k = m - (m & (m - 1));
        System.out.println(k);



    }
}
