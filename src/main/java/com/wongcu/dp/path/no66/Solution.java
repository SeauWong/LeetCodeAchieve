package com.wongcu.dp.path.no66;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for(int i = 1; i< nums.length;i++){
            if(sum > 0){
                sum += nums[i];
            }else {
                sum = nums[i];
            }
            result = Math.max(result, sum);

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxSubArray(new int[]{-1, 2, -1, 3, 5, -3});
        System.out.println(i);
    }
}
