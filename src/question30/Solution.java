package question30;

import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/15 16:34
 * Describe: 包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<>();
    //辅助栈，每次压入最小元素
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 思路：使用一个辅助栈保存每次push后的最小元素，当最小元素从stack1中弹出后应该同时弹出stack2中的当前最小元素
     */
    public void push(int node) {
        if(stack1.empty()){
            stack2.push(node);
        }else {
            if(node < stack2.peek()){
                stack2.push(node);
            }
        }
        stack1.push(node);
    }

    public void pop() {
        int out = stack1.pop();
        if(stack2.peek() == out){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(3);
        System.out.println(solution.min());
    }
}
