package com.wongcu.array;

import java.util.ArrayList;
import java.util.List;

public class No54 {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        });
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int upBound = 0, downBound = m - 1, leftBound = 0, rightBound = n - 1;
            int totalCount = m * n;
            List<Integer> rs = new ArrayList<>(totalCount);
            while (rs.size() < totalCount) {
                //从左往右
                if (upBound <= downBound) {
                    for (int col = leftBound; col <= rightBound; col++) {
                        rs.add(matrix[upBound][col]);
                    }
                    //上边界++
                    upBound++;
                }

                //从上往下
                if (leftBound <= rightBound) {
                    for (int row = upBound; row <= downBound; row++) {
                        rs.add(matrix[row][rightBound]);
                    }
                    //右边界--
                    rightBound--;
                }

                //从右往左
                if (upBound <= downBound) {
                    for (int col = rightBound; col >= leftBound; col--) {
                        rs.add(matrix[downBound][col]);
                    }
                    //下边界--
                    downBound--;
                }

                //从下往上
                if (leftBound <= rightBound) {
                    for (int row = downBound; row >= upBound; row--) {
                        rs.add(matrix[row][leftBound]);
                    }
                    //左边界++
                    leftBound++;
                }
            }
            return rs;
        }
    }
}
