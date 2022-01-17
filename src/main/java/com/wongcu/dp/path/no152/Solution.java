package com.wongcu.dp.path.no152;

public class Solution {

    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int imax = nums[0];
        int imin = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length;i++){
            int x = imax * nums[i];
            int y = imin * nums[i];
            imax = Math.max(Math.max(nums[i], x), y);
            imin = Math.min(Math.min(nums[i], x), y);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxProduct(new int[]{-1, 1, 2, 4, -4});
        System.out.println(i);
    }
}
