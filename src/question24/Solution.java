package question24;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 11:53
 * Describe: 反转链表
 * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode nextNode = null;
        ListNode preNode = null;
        ListNode node = head;
        ListNode nHead = head;
        while (node != null){
            nextNode = node.next;
            if(nextNode == null){
                nHead = node;
            }
            node.next = preNode;
            preNode = node;
            node = nextNode;

        }
        return nHead;
    }
}
