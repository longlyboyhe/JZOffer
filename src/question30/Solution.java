package question30;

import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/15 16:34
 * Describe: ����min������ջ
 * ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min�������ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)��
 */
public class Solution {

    Stack<Integer> stack1 = new Stack<>();
    //����ջ��ÿ��ѹ����СԪ��
    Stack<Integer> stack2 = new Stack<>();

    /**
     * ˼·��ʹ��һ������ջ����ÿ��push�����СԪ�أ�����СԪ�ش�stack1�е�����Ӧ��ͬʱ����stack2�еĵ�ǰ��СԪ��
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
