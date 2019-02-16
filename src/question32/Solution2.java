package question32;

import question30.Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 13:53
 * Describe: �ֲ���ϵ��´�ӡ������
 * ��Ŀ�����ϵ��°����ӡ��������ͬһ��Ľڵ㰴�����ҵ�˳���ӡ��ÿһ���ӡ��һ�С�
 */
public class Solution2 {

    /**
     * ˼·��ʹ��һ��nectLevel��¼��һ����Ҫ��ӡ�Ľڵ�����toBePrinted��¼��ǰ�㻹û�д�ӡ�Ľڵ���
     */
    public static void PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }

        queue.add(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        TreeNode node = null;
        while ((node = queue.poll()) != null){
            if(node.left != null){
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevel++;
            }
            System.out.print(node.val + " ");
            toBePrinted--;
            if(toBePrinted == 0){
                System.out.println();
                toBePrinted = nextLevel;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode treeNode1 = new TreeNode(6);
        root.left = treeNode1;
        TreeNode treeNode2 = new TreeNode(10);
        root.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(5);
        treeNode1.left = treeNode3;
        TreeNode treeNode4 = new TreeNode(7);
        treeNode1.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(9);
        treeNode2.left = treeNode5;
        TreeNode treeNode6 = new TreeNode(11);
        treeNode2.right = treeNode6;

        Solution2.PrintFromTopToBottom(root);
    }
}
