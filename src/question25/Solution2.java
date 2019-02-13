package question25;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 13:08
 * Describe: 合并两个排序的链表
 */
public class Solution2 {

    /**
     * 非递归方法
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode node = list1.val < list2.val ? list1 : list2, rNode = node;

        if(node == list1){
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if(list1 != null){
            node.next = list1;
        }
        if(list2 != null){
            node.next = list2;
        }
        return rNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);node1.next = node3;
        ListNode node5 = new ListNode(5);node3.next = node5;

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);node2.next = node4;
        ListNode node6 = new ListNode(6);node4.next = node6;

        ListNode node = Solution2.Merge(node1, node2);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
