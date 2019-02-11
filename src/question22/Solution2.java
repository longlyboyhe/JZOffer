package question22;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 23:03
 * Describe: 链表中倒数第k个节点
 */
public class Solution2 {

    /**
     * 看到的一个代码简洁的算法，哭死，一般人还真写不出来
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k){
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);listNode4.next = listNode5;

        System.out.println(Solution2.FindKthToTail(listNode1, 5).val);
    }

}
