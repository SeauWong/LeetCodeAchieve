package com.wongcu.search.binary.no69;
class Solution {
    public int mySqrt(int x) {
        //二分从[0,x] 中找到最后一个 n^2 <= x的数
        if(x == 1){
            return 1;
        }

        int left = 0;
        int right = x;
        while(left <= right){
            int mid = (left + right) >> 1;
            System.out.println(mid);
            int rs = mid * mid;
            if(rs > x){
                right = mid - 1;
            }else if(rs < x && ((mid+1) * (mid+1) <= x)){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(Integer.MAX_VALUE));
    }
}
