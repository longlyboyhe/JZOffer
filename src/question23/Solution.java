package question23;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 22:07
 * Describe: 链表中环的入口节点
 * 题目：如果一个链表中包含环，如何找出环的入口节点？
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {

    /**
     * 思路：
     * 给定一个头节点需要对其进行判空，其次判断该链表是否有环，若有环，则需要知道环中元素个数k，然后定义两个指针，其中一个指针从头节点出发，另一个指针先走k步
     * 然后两个指针再同时出发，相遇节点则为链表中环的入口节点
     *
     * 如何判断有环？
     * 需要两个指针分别遍历节点，一个走的快，一个走的慢，判断快指针是否会遍历到尾节点，即node == null，则无环。当快节点与慢节点相遇时则说明有环。
     *
     * 如何确定环中元素个数？
     * 获得快慢节点相遇的节点，该节点一定位于环中，从该节点出发，并同时计数，循环直到下一次遍历到该相遇节点。
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode mettingNode = mettingNode(pHead);
        if(mettingNode == null){
            return null;
        }
        int count = 1;
        ListNode node = mettingNode.next;
        while (node != mettingNode){
            node = node.next;
            count++;
        }
        ListNode fast = pHead, slow = pHead;
        for (int i=0;i<count;i++){
            fast = fast.next;
        }
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private static ListNode mettingNode(ListNode pHead){
        if(pHead == null){
            return null;
        }
        ListNode slow = pHead.next;
        if(slow == null){
            return null;
        }
        ListNode fast = slow.next;
        while (fast != null){
            if(fast == slow){
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return null;
    }
}
