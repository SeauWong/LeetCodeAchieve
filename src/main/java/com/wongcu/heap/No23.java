package com.wongcu.heap;

import com.wongcu.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{};
        System.out.println(lists.length);
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(null == lists || lists.length == 0){
                return null;
            }

            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
            for(ListNode node : lists){
                if(null != node){
                    priorityQueue.add(node);
                }
            }

            if(priorityQueue.isEmpty()){
                return null;
            }

            ListNode head = new ListNode(0, null);
            ListNode cur = head;
            while(!priorityQueue.isEmpty()){
                cur.next = priorityQueue.remove();
                cur = cur.next;
                if(cur.next != null){
                    priorityQueue.add(cur.next);
                }
            }

            return head.next;
        }
    }
}
