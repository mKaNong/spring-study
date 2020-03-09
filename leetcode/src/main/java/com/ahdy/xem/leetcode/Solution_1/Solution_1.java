package com.ahdy.xem.leetcode.Solution_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        /*HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                arr[0] = map.get(nums[i]);
                arr[1] = i;
                return arr;
            }
            map.put(target - nums[i], i);
        }*/

         // 双重循环 循环极限为(n^2-n)/2
         for(int i = 0; i < nums.length; i++){
             for(int j = nums.length - 1; j > i; j --){
                 if(nums[i]+nums[j] == target){
                     arr[0] = i;
                     arr[1] = j;
                    return arr;
                 }
             }
         }

        return arr;
    }
}
