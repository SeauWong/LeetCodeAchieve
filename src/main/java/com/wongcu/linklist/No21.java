package com.wongcu.linklist;

import com.wongcu.utils.ListUtil;

public class No21 {

    public static void main(String[] args) {
        ListNode list1 = ListUtil.buildFromArr(new int[]{1, 2, 4});
        ListNode list2 = ListUtil.buildFromArr(new int[]{1, 3, 4});

        Solution s = new Solution();
        ListNode listNode = s.mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            ListNode head = new ListNode();
            ListNode cur = head;

            while (list1 != null && list2 != null) {
                ListNode tmp;
                if (list1.val < list2.val) {
                    tmp = list1;
                    list1 = list1.next;
                } else {
                    tmp = list2;
                    list2 = list2.next;
                }
                cur.next = tmp;
                cur = tmp;
            }

            while (list1 != null) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }


            while (list2 != null) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }

            return head.next;
        }
    }
}
