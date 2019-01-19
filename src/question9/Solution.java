package question9;

import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 15:00
 * Describe: 用两个栈实现队列
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 思路：当入队时操作栈1，出队时将栈1中元素依次压入栈2，当需要再入队时将栈2再压回栈1
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
