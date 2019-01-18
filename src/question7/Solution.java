package question7;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 16:30
 * Describe:
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
