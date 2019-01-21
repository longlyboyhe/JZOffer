package question18;

/**
 * @author: zhangocean
 * @Date: 2019/1/21 15:22
 * Describe: 删除链表的节点
 * 题目：在O(1)的时间内删除链表节点。给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点
 */
class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
public class Solution1 {

    public static ListNode deleteNode(ListNode root, ListNode listNode){

        //链表中只有一个节点
        if(listNode.next == null && root == listNode){
            listNode = null;
            root = null;
        }
        //该节点处于尾节点上
        else if(listNode.next == null){
            ListNode pre = root;
            while (pre.next != listNode){
                pre = pre.next;
            }
            pre.next = null;
        }
        //该节点是中间节点
        else {
            listNode.value = listNode.next.value;
            listNode.next = listNode.next.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        printNode(root);
        printNode(deleteNode(root, node2));
    }

    public static void printNode(ListNode root){
        while (root != null){
            System.out.print(root.value + " ");
            root = root.next;
        }
        System.out.println();
    }

}
