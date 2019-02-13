package question25;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 12:50
 * Describe: �ϲ��������������
 * ��Ŀ������������������������ϲ�����������ʹ�������еĽڵ���Ȼ�ǵ�������ġ�
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution1 {

    /**
     * �ݹ鷽��
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode node = null;

        if(list1.val < list2.val){
            node = list1;
            node.next = Merge(list1.next, list2);
        } else {
            node = list2;
            node.next = Merge(list1, list2.next);
        }

        return node;
    }

}
