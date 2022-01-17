package com.wongcu.dp.path.no746;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1){
            return cost[0];
        }else if(n == 2){
            return Math.min(cost[0], cost[1]);
        }

        for(int i = 2; i < n; i++){
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[n-1], cost[n-2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(i);
    }
}
