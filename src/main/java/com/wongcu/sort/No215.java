package com.wongcu.sort;

public class No215 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int kthLargest = s.findKthLargest(new int[]{3, 3, 3, 3, 4, 3, 3, 3, 3}, 1);
        System.out.println(kthLargest);

    }

    static class Solution {

        public int findKthLargest(int[] nums, int k) {
            sort(nums, 0, nums.length - 1, k);
            return nums[nums.length - k];
        }

        public void sort(int[] a, int p, int r, int k) {
            if (p >= r || a.length - k < p || a.length - k > r) {
                //不在区间里，不排了
                return;
            }

            //排序
            int pivot = a[r], i = p;
            for (int j = p; j < r; j++) {
                // pivot  < a[i](pivot) < pivot
                if (a[j] < pivot) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                }
            }
            a[r] = a[i];
            a[i] = pivot;

            if (i == a.length - k) {
                return;
            }

            //下一轮
            sort(a, p, i - 1, k);
            sort(a, i + 1, r, k);
        }
    }
}
