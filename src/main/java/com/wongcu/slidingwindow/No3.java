package com.wongcu.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class No3 {

    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0, max=0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char rc = s.charAt(right++);
            if(set.contains(rc)){
                max = max > set.size() ? max : set.size();
                while(set.contains(rc)){
                    set.remove(s.charAt(left++));
                }
            }
            set.add(rc);
        }
        return max > set.size() ? max : set.size();
    }

    public static void main(String[] args) {
        No3 solution = new No3();
        System.out.println(solution.lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
