package com.wongcu.dp.path.no983;

public class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1]];
        for(int i = 1; i < dp.length; i++){

        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
        System.out.println(i);
    }
}
