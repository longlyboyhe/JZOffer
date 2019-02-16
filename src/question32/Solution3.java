package question32;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 14:16
 * Describe: 之字形打印二叉树
 * 题目：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution3 {

    /***
     * 使用两个栈分别存储从左到右以及从右到左打印的数
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null){
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);
        int level = 1;
        while (!stack1.empty() || !stack2.empty()){
            ArrayList<Integer> list1 = new ArrayList<>();
            //奇数层
            if((level & 0x1) == 1){
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    if(node.left != null){
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                    list1.add(node.val);
                }
                level++;
            }
            //偶数层
            else {
                while (!stack2.empty()){
                    TreeNode node = stack2.pop();
                    if(node.right != null){
                        stack1.push(node.right);
                    }
                    if(node.left != null){
                        stack1.push(node.left);
                    }
                    list1.add(node.val);
                }
                level++;
            }
            list.add(list1);
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

        Solution3.Print(root);
    }

}
