package com.wongcu.linklist;

import com.wongcu.utils.ListNode;

public class No25 {

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1) {
                return head;
            }
            ListNode nHead = head, l = head, r, cur, pre, tmp, nl = head, nr;

            while (true) {
                //寻找下一组左右位置
                nr = nl;
                for (int i = 1; i < k; i++) {
                    nr = nr.next;
                    if (nr == null) {
                        //下一组不够k个元素了
                        if (l != null) {
                            //上组左边->下组左边
                            l.next = nl;
                        }
                        return nHead;
                    }
                }

                //第一次换头节点
                if (nHead == head) {
                    nHead = nr;
                } else {
                    //上组左边接到下组右边
                    l.next = nr;
                }

                l = nl;
                r = nr;
                nl = nr.next;
                cur = l;
                pre = cur.next;

                while (cur != r) {
                    tmp = pre.next;
                    pre.next = cur;
                    cur = pre;
                    pre = tmp;
                }

                //正好完结
                if(nl == null){
                    l.next = null;
                    return nHead;
                }
            }
        }
    }

    public static void main(String[] args) {
        No25 no25 = new No25();
//        ListNode listNode = no25.buildChain(new int[]{1,2,3,4,5});
        ListNode listNode = no25.buildChain(new int[]{1, 2});
        Solution solution = new Solution();
        ListNode listNode1 = solution.reverseKGroup(listNode, 2);
        print(listNode1);
    }

    public static void print(ListNode listNode) {
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode buildChain(int[] arr) {
        ListNode head = null, tmp = null;
        for (int i : arr) {
            ListNode cur = new ListNode(i, null);
            if (head == null) {
                head = cur;
            }
            if (tmp != null) {
                tmp.next = cur;
            }
            tmp = cur;
        }
        return head;
    }
}
