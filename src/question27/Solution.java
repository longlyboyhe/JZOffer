package question27;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 18:19
 * Describe: 二叉树的镜像
 * 题目：请完成一个函数，输入一颗二叉树，该函数输出它的镜像
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {

    public void Mirror(TreeNode root) {
        treeMirror(root);
    }

    private TreeNode treeMirror(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode oldNode = root.left;
        root.left = treeMirror(root.right);
        root.right = treeMirror(oldNode);
        return root;
    }
}
