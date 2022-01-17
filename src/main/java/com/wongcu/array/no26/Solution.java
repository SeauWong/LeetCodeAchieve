package com.wongcu.array.no26;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pre]) {
                nums[++pre] = nums[i];
            }
        }
        return pre + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {0, 0, 1, 1, 2, 3, 4, 5, 5};
        int i = solution.removeDuplicates(ints);
        System.out.println(i);
        Arrays.stream(ints).forEach(System.out::print);
    }
}
