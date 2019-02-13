package question25;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 12:50
 * Describe: 合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
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
     * 递归方法
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
