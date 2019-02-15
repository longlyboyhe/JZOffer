package question31;

import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/15 17:01
 * Describe: ջ��ѹ�롢��������
 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 * ���磬����{1,2,3,4,5}��ĳջ��ѹջ���У�����{4,5,3,2,1}�Ǹ�ѹջ���ж�Ӧ��һ���������У���{4,3,5,1,2}�Ͳ������Ǹ�ѹջ���еĵ������С�
 */
public class Solution {

    /**
     * ʹ��һ������ջ������ѹ���һ�������е�Ԫ��
     * �����һ�����������ָպ���ջ�����֣���ôֱ�ӵ����������һ�����������ֲ���ջ�������ѹջ�����л�û����ջ������ѹ�븨��վ��ֱ������һ����Ҫ����������ѹ��ջ������������ֶ�ѹ��ջ����û���ҵ���һ�����������֣���ô�����в�������һ���������С�
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
