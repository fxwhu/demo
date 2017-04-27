package com.bmss.test.dubbo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by fengxuan1 on 2016/10/19.
 */
public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int a = nums[i];
            for(int j = i + 1; j < nums.length - 1; j++){
                int b = nums[j];
                for(int k = j + 1; k < nums.length; k++){
                    int c = nums[k];
                    int zero = a + b + c;
                    if(zero == 0) {
                        List<Integer> zerolist = new ArrayList<>();
                        zerolist.add(a);
                        zerolist.add(b);
                        zerolist.add(c);
                        Collections.sort(zerolist);
                        if(!result.contains(zerolist)) {
                            result.add(zerolist);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum1(new int[]{-2,0,0,2,2});
        System.out.println(JSON.toJSONString(result));
    }



    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2 ; i++){
            if(i == 0||(i > 0 && nums[i] != nums[i-1])){
                int first = nums[i];
                int begin = i + 1, hi = nums.length -1 ,sum = 0 - first;
                while (begin < hi){
                    if(nums[begin] + nums[hi] == sum){
                            result.add(Arrays.asList(first, nums[begin], nums[hi]));
                            begin++;
                            hi--;
                        while (begin < hi && nums[begin] == nums[begin -1])
                            begin ++;
                        while (begin < hi && nums[hi] == nums[hi + 1])
                            hi ++;
                    }else if(nums[begin] + nums[hi] < sum){
                        begin ++;
                    }else {
                        hi --;
                    }
                }
            }
        }
        return result;
    }




    public static int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int last = target- nums[i];
            if(map.containsKey(last) && map.get(last) != i){
                return new int[]{i, map.get(last)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSum1(List<Integer> list, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for(int i = 0; i < list.size(); i++){
            int last = target- list.get(i);
            if(map.containsKey(last) && map.get(last) != i){
                return new int[]{i, map.get(last)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
