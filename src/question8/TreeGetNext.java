package question8;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 13:34
 * Describe: 二叉树的下一个节点
 * 题目：给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、右节点的指针，还有一个指向父节点的指针。
 */
public class TreeGetNext {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 有三种情况：
     *              1、节点有右子树。则下一个节点是右子树中最左边的节点。
     *              2、节点无右子树。
     *                          a、该节点是父节点的左子树。则下一个节点是该节点的父节点。
     *                          b、该节点是父节点的右子树，则需要向上找到一个节点是它父节点的左节点的节点，下一个节点则是找到的这个节点的父节点
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        //有右子树情况
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //无右子树
        while (pNode.next != null){
            if (pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
