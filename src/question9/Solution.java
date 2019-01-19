package question9;

import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 15:00
 * Describe: ������ջʵ�ֶ���
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * ˼·�������ʱ����ջ1������ʱ��ջ1��Ԫ������ѹ��ջ2������Ҫ�����ʱ��ջ2��ѹ��ջ1
     */
    public void push(int node) {
        if(stack1.empty() && !stack2.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
    }

    public int pop() {
        if(!stack1.empty() && stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
