package question6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:55
 * Describe: ��β��ͷ��ӡ����
 * ��Ŀ������һ�������ͷ�ڵ㣬��β��ͷ��������ӡ��ÿ���ڵ��ֵ��
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

}
