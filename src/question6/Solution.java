package question6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:55
 * Describe: 从尾到头打印链表
 * 题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
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
