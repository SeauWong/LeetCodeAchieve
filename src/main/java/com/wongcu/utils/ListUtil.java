package com.wongcu.utils;

public class ListUtil {

    public static ListNode buildFromArr(int[] arr){
        ListNode head = new ListNode();
        ListNode cur = head;
        for(int num : arr){
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return head.next;
    }
}
