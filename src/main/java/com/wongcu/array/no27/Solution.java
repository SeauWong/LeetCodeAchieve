package com.wongcu.array.no27;

import java.util.Arrays;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[--n];
            }else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {0, 0, 1, 1, 2, 3, 4, 5, 5};
        int i = solution.removeElement(ints, 1);
        System.out.println(i);
        Arrays.stream(ints).limit(i).forEach(System.out::print);
    }
}
