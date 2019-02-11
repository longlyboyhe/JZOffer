package question22;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 15:58
 * Describe:链表中倒数第k个节点
 * 题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值一次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public static ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode nodeA = head, nodeB = head;
        for (int i=0;i<k;i++){
            if(nodeA != null){
                nodeA = nodeA.next;
            } else {
                return null;
            }
        }
        while (nodeA != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeB;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);listNode4.next = listNode5;

        System.out.println(Solution.FindKthToTail(listNode1, 5).val);
    }

}
