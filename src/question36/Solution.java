package question36;
import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 13:25
 * Describe: ������������˫������
 * ��Ŀ������һ�Ŷ��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 */
public class Solution {

    /**
     * �������������ʣ�ÿ���ڵ������������нڵ�С�ڸýڵ㣬���������нڵ���ڸýڵ㣬���ǿ���ͨ���������������ź��������
     *
     * ���ʹ�����������
     * ��ÿ���ڵ���������������ڵ�ѹ��ջ��Ȼ��ÿ�ε���ջ��Ԫ�أ�����ǰһ�������Ϊ��־��Ȼ���ٱ���ÿ���ڵ�����������൱�ڰ�Ԫ�ذ���ѹ��ջ��Ȼ�󵯳�ջ��Ԫ�����ö�Ӧ��
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        TreeNode pre = null;
        while (pRootOfTree != null || !stack.empty()){
            while (pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            TreeNode node = stack.pop();
            if(head == null){
                head = node;
                pre = node;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            pRootOfTree = node.right;
        }
        return head;
    }

}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
