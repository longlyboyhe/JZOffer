package question18;

/**
 * @author: zhangocean
 * @Date: 2019/1/21 15:22
 * Describe: ɾ������Ľڵ�
 * ��Ŀ����O(1)��ʱ����ɾ������ڵ㡣�������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ����ɾ���ýڵ�
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

        //������ֻ��һ���ڵ�
        if(listNode.next == null && root == listNode){
            listNode = null;
            root = null;
        }
        //�ýڵ㴦��β�ڵ���
        else if(listNode.next == null){
            ListNode pre = root;
            while (pre.next != listNode){
                pre = pre.next;
            }
            pre.next = null;
        }
        //�ýڵ����м�ڵ�
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
