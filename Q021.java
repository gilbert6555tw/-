/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Administrator
 */
public class Q021 {
    public static void main(String[] args) {
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        //
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode firstNode = new Q021().mergeTwoLists(l1, l2);
        System.out.println("firstNode="+toString(firstNode));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 || null == l2){
            return null == l1? l2:l1;
        }
        
        ListNode tempNode = new ListNode(0);
        ListNode firstNode = tempNode;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        if(l1 != null){
            while (l1 != null) {
                tempNode.next = l1;
                l1 = l1.next;
                tempNode = tempNode.next;
            }
        }else if(l2 != null){
            while (l2 != null) {
                tempNode.next = l2;
                l2 = l2.next;
                tempNode = tempNode.next;
            }
        }

        return firstNode.next;
    }

    public static String toString(ListNode l1) {
        StringBuilder sb = new StringBuilder();
        ListNode tempNode = l1;
        while (tempNode != null) {
            sb.append(tempNode.val).append("->");
            tempNode = tempNode.next;
        }
        return sb.toString();
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; };
    
}
 
