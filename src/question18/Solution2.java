package question18;

/**
 * @author: zhangocean
 * @Date: 2019/1/21 15:45
 * Describe: ɾ���������ظ��Ľڵ�
 * ��Ŀ����һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 *          ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head, now = pHead;

        head.next = pHead;
        while (now != null && now.next != null){
            if(now.val == now.next.val){
                int val = now.val;
                while (now != null && now.val == val){
                    now = now.next;
                }
                pre.next = now;
            } else {
                pre = now;
                now = now.next;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        printNode(root);
        printNode(deleteDuplication(root));
    }

    public static void printNode(ListNode root){
        while (root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

}
