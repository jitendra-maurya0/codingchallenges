package com.sample.question.linkedlist;

import com.sample.question.linkedlist.ListNode;

public class RemoveKthNodeFromLast {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int t = count(head) - n;

        ListNode temp = head;
        int c =0;
        while(c != t){
            c++;
            temp = temp.next;

        }
        temp = temp.next;
        head = temp;

        return head;
    }


    static int count(ListNode head){
        int count=0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

       ListNode temp =  removeNthFromEnd(head,2);
       while (temp != null){
           System.out.println(temp.data);
           temp = temp.next;
       }

    }
}
