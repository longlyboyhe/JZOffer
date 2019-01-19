package question8;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 13:34
 * Describe: ����������һ���ڵ�
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
     * �����������
     *              1���ڵ���������������һ���ڵ���������������ߵĽڵ㡣
     *              2���ڵ�����������
     *                          a���ýڵ��Ǹ��ڵ��������������һ���ڵ��Ǹýڵ�ĸ��ڵ㡣
     *                          b���ýڵ��Ǹ��ڵ��������������Ҫ�����ҵ�һ���ڵ��������ڵ����ڵ�Ľڵ㣬��һ���ڵ������ҵ�������ڵ�ĸ��ڵ�
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        //�����������
        if(pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        //��������
        while (pNode.next != null){
            if (pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
