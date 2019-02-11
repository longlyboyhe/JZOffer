package question22;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 15:58
 * Describe:�����е�����k���ڵ�
 * ��Ŀ������һ����������������е�����k���ڵ㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ�������������β�ڵ��ǵ�����һ���ڵ㡣
 * ���磬һ��������6���ڵ㣬��ͷ�ڵ㿪ʼ�����ǵ�ֵһ����1��2��3��4��5��6���������ĵ�����3���ڵ���ֵΪ4�Ľڵ㡣
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
