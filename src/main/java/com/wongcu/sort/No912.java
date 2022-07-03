package com.wongcu.sort;

import java.util.Arrays;

public class No912 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = s.sortArray(new int[]{3, 2, 1, 4, 5});
        Arrays.stream(ints).forEach(System.out::println);
    }

    public static class Solution {
        public int[] sortArray(int[] nums) {
            quitSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quitSort(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            int pivot = nums[r];
            int i = l;
            for (int j = 0; j < r; j++) {
                if (nums[j] < pivot) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    i++;
                }
            }
            nums[r] = nums[i];
            nums[i] = pivot;

            quitSort(nums, l, i - 1);
            quitSort(nums, i + 1, r);
        }
    }
}
