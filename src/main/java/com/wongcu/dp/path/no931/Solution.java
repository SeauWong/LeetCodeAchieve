package com.wongcu.dp.path.no931;

import java.util.Arrays;

public class Solution {

    public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                } else if (j == A[0].length - 1) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
                } else {
                    A[i][j] += Math.min(Math.min(A[i - 1][j - 1], A[i - 1][j]), A[i - 1][j + 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : A[A.length - 1]){
            min = Math.min(i,min);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(i);
    }
}
