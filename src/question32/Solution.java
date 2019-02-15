package question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zhangocean
 * @Date: 2019/2/15 20:21
 * Describe: 从上到下打印二叉树
 * 题目：不分行从上到下打印二叉树。丛上到下打印二叉树的么个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution {

    /**
     * 利用队列性质，将每个节点的子节点入队，打印出队元素
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
