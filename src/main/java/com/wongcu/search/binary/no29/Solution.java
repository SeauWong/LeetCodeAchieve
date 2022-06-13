package com.wongcu.search.binary.no29;


class Solution {
    public int divide(int dividend, int divisor) {
        //除数为0
        if(dividend == 0){
            return 0;
        }
        //被除数为1
        if(divisor == 1){
            return dividend;
        }
        //大于最大值的情况，返回最大值
        if(Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //符号
        boolean negative = ((dividend ^ divisor) >>> 31) == 1 ? true : false;

        //将divisor倍数级相加，divisor <<= 1，直到 divisor > dividend，
        //记录加了多少次 (quotient <<= 1)
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int rs = 0;
        while(dvs <= dvd){
            long tmp = dvs;
            int cnt = 1;
            while((tmp<<1) <= dvd){
                tmp <<= 1;
                cnt <<= 1;
            }
            dvd -= tmp;
            rs += cnt;
        }
        return negative ? -rs : rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648,2));
    }
}