package question31;

import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/15 17:01
 * Describe: 栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列{1,2,3,4,5}是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4,3,5,1,2}就不可能是该压栈序列的弹出序列。
 */
public class Solution {

    /**
     * 使用一个辅助栈来依次压入第一个序列中的元素
     * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助站。直到把下一个需要弹出的数组压入栈。如果所有数字都压入栈后仍没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || popA.length != pushA.length){
            return false;
        }
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[i++]);
        while (j < popA.length){
            while (stack.peek() != popA[j]){
                if(i == pushA.length){
                    return false;
                }
                stack.push(pushA[i++]);
            }
            stack.pop();
            j++;
        }
        return true;
    }

}
