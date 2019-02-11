package question23;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 22:07
 * Describe: �����л�����ڽڵ�
 * ��Ŀ�����һ�������а�����������ҳ�������ڽڵ㣿
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
     * ˼·��
     * ����һ��ͷ�ڵ���Ҫ��������пգ�����жϸ������Ƿ��л������л�������Ҫ֪������Ԫ�ظ���k��Ȼ��������ָ�룬����һ��ָ���ͷ�ڵ��������һ��ָ������k��
     * Ȼ������ָ����ͬʱ�����������ڵ���Ϊ�����л�����ڽڵ�
     *
     * ����ж��л���
     * ��Ҫ����ָ��ֱ�����ڵ㣬һ���ߵĿ죬һ���ߵ������жϿ�ָ���Ƿ�������β�ڵ㣬��node == null�����޻�������ڵ������ڵ�����ʱ��˵���л���
     *
     * ���ȷ������Ԫ�ظ�����
     * ��ÿ����ڵ������Ľڵ㣬�ýڵ�һ��λ�ڻ��У��Ӹýڵ��������ͬʱ������ѭ��ֱ����һ�α������������ڵ㡣
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
