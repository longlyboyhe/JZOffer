package question26;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 13:49
 * Describe: 树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构
 */
public class Solution {

    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if(root1 != null && root2 != null){
            if(isEqual(root1, root2)){
                result = doesTreeHaveTree(root1, root2);
            }
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    public static boolean doesTreeHaveTree(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(!isEqual(root1, root2)){
            return false;
        }
        return doesTreeHaveTree(root1.left, root2.left) && doesTreeHaveTree(root1.right, root2.right);
    }

    public static boolean isEqual(TreeNode root1,TreeNode root2){
        return root1.val == root2.val;
    }

    public static void main(String[] args) { 
        TreeNode tree1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        tree1.left=node1;
        tree1.right = node2;

        TreeNode tree2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        tree2.left=node3;
        tree2.right=node4;
        System.out.println(HasSubtree(tree1,tree2));
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
