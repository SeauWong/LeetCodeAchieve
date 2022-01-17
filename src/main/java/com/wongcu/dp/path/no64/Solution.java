package com.wongcu.dp.path.no64;

public class Solution {

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        //初始化第0行
        for (int i = 1; i < c; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        //初始化第0列
        for (int i = 1; i < r; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[r - 1][c - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        });
        System.out.println(i);
    }
}
