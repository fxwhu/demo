package com.bmss.test.dubbo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengxuan1 on 2016/10/18.
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer value = map.get(nums[i]);
            if(value == null){
                map.put(nums[i], i);
            }
            int last = target - nums[i];
            Integer lastIndice = map.get(last);
            if(lastIndice != null && lastIndice < i){
                result[0] = lastIndice;
                result[1] = i;
                return result;
            }
        }
        return result;
    }


    /**
     * Time complexity : O ( n )
     * Space complexity : O ( n )
     */
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


    public static int[] twoSum2(int[] nums, int target){
        int[] result = new int[2];
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(JSON.toJSONString(twoSum1(nums, target)));
    }
}
