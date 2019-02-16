package question35;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 16:59
 * Describe:��������ĸ���
 * ��Ŀ����ʵ��һ������������һ�����������ڸ��������У�ÿ���ڵ������һ��nextָ��ָ����һ���ڵ㣬����һ��siblingָ��ָ�������е�����ڵ����null��
 */
public class Solution {

    /**
     * ˼·��
     * 1�����ȸ���ÿһ���ڵ㣬�������ƺ�Ľڵ���뵽ԭ�ڵ�ĺ��档A-B-C ��> A-A1-B-B1-C-C1
     * 2������������ԭ�ڵ�����ָ��ָ�������ڵ�ĸ��ƽڵ��ԭ�ڵ�ĸ��ƽڵ㡣A.random = A1.random
     * 3�����γɵ��ı��ֳ���������A-A1-B-B1-C-C1 ��> A-B-C �� A1-B1-C1
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode currentNode = pHead;
        //1������ÿһ���ڵ�
        while (currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        //2��Ϊÿһ���ڵ��������ڵ�ָ��
        currentNode = pHead;
        while (currentNode != null){
            currentNode.next.random = (currentNode.random == null ? null : currentNode.random.next);
            currentNode = currentNode.next.next;
        }

        //3�����Ϊ������
        currentNode = pHead;
        RandomListNode cloneHead = currentNode.next;
        RandomListNode nHead = cloneHead;
        while (currentNode != null){
            currentNode.next = cloneHead.next;
            cloneHead.next = (currentNode.next==null ? null : currentNode.next.next);
            currentNode = currentNode.next;
            cloneHead = cloneHead.next;
        }
        return nHead;
    }

}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
