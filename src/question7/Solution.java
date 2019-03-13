package question7;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 16:30
 * Describe:重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复数字。
 * 例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建如下图所示的二叉树并输出它的头节点。
 */
public class Solution {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        TreeNode treeNode = build(pre, in, 0, pre.length-1, 0, in.length-1);
        return treeNode;
    }

    public TreeNode build(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        for(int i=inLeft,j=inRight;i<=j;i++){
            if(in[i] == pre[preLeft]){
                root.left = build(pre, in, preLeft+1, preLeft+i-inLeft, inLeft, i-1);
                root.right = build(pre, in, i-inLeft+preLeft+1, preRight, i+1, inRight);
                break;
            }
        }
        return root;
    }
}
