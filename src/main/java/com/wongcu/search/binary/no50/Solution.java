package com.wongcu.search.binary.no50;

class Solution {
    public double myPow(double x, int n) {
        //思路和两数相除一样，x不停叠乘，cnt << 2，直到>n时，重新叠乘
        if(n == 0){
            return 1;
        }

        x = n < 0 ? 1/x : x;
        double rs = 1;
        long nl = n;
        nl = Math.abs(nl);
        while(0 < nl){
            double innerRs = x;
            long cnt = 1;
            while((cnt<<1) <= nl){
                cnt <<= 1;
                innerRs *= innerRs;
            }
            nl -= cnt;
            rs *= innerRs;
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, Integer.MIN_VALUE));
    }
}