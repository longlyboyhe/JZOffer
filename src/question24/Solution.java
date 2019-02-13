package question24;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 11:53
 * Describe: ��ת����
 * ��Ŀ������һ������������һ�������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ㡣
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
