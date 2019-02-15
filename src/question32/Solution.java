package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhangocean
 * @Date: 2019/2/15 20:21
 * Describe: ���ϵ��´�ӡ������
 * ��Ŀ�������д��ϵ��´�ӡ�����������ϵ��´�ӡ��������ô���ڵ㣬ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ��
 */
public class Solution {

    /**
     * ���ö������ʣ���ÿ���ڵ���ӽڵ���ӣ���ӡ����Ԫ��
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        queue.add(root);
        TreeNode node = null;
        while ((node = queue.poll()) != null){
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            list.add(node.val);
        }
        return list;
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
