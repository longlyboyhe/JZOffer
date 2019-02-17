package question36;
import java.util.Stack;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 13:25
 * Describe: 二叉搜索树与双向链表
 * 题目：输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Solution {

    /**
     * 二叉搜索树性质：每个节点其左子树所有节点小于该节点，右子树所有节点大于该节点，于是可以通过中序遍历来获得排好序的数据
     *
     * 如何使用中序遍历？
     * 将每个节点的左子树包括根节点压入栈，然后每次弹出栈顶元素，设置前一个结点作为标志，然后再遍历每个节点的右子树。相当于把元素按序压入栈，然后弹出栈顶元素设置对应链
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        TreeNode pre = null;
        while (pRootOfTree != null || !stack.empty()){
            while (pRootOfTree != null){
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }
            TreeNode node = stack.pop();
            if(head == null){
                head = node;
                pre = node;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            pRootOfTree = node.right;
        }
        return head;
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
