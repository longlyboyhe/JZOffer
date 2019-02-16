package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 13:53
 * Describe: 分层从上到下打印二叉树
 * 题目：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution2 {

    /**
     * 思路：使用一个nectLevel记录下一层需要打印的节点数。toBePrinted记录当前层还没有打印的节点数
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        if(pRoot == null){
            return list;
        }

        queue.add(pRoot);
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
            list1.add(node.val);
            toBePrinted--;
            if(toBePrinted == 0){
                list.add(list1);
                list1 = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return list;
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

        Solution2.Print(root);
    }
}
