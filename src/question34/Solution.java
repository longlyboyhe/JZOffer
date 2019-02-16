package question34;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 15:54
 * Describe:二叉树中和为某一值的路径
 * 题目：输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 */
public class Solution {

    /**
     * 思路：获得所有根节点到叶子节点的值等于给定整数，因此需要递归所有到叶子节点的路径，每次遍历时需要将当前节点值放入list中，当回退到父节点时需要删除当前节点的list值
     *
     * 当递归到叶子节点时判定当前list中的路径值是否等于给定的整数，若是则放入lists中
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return lists;
        }
        int count = 0;
        FindPath(root, target, count, lists, list);
        return lists;
    }

    public void FindPath(TreeNode root, int target, int count, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list) {
        if(root == null){
            return;
        }
        count += root.val;
        if(root.left == null && root.right == null){
            if(count == target){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }

        list.add(root.val);
        FindPath(root.left, target, count, lists, list);
        FindPath(root.right, target, count, lists, list);
        list.remove(list.size()-1);
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
