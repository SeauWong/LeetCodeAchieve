package com.wongcu.array.no66;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        for(int n = digits.length - 1; n >=0; n--){
            digits[n]++;
            digits[n] %= 10;
            if(digits[n] != 0) return digits;
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.plusOne(new int[]{9, 9, 9});
        Arrays.stream(ints).forEach(System.out::print);
    }
}
