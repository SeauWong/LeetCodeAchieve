package com.wongcu.array.no1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            int delta = target - nums[i];
            if(map.containsKey(delta)){
                return new int[]{map.get(delta), i};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{1, 2, 3, 5, 6}, 11);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
