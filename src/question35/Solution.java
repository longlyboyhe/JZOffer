package question35;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 16:59
 * Describe:复杂链表的复制
 * 题目：请实现一个函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个sibling指针指向链表中的任意节点或者null。
 */
public class Solution {

    /**
     * 思路：
     * 1、首先复制每一个节点，并将复制后的节点插入到原节点的后面。A-B-C —> A-A1-B-B1-C-C1
     * 2、遍历链表，将原节点的随机指针指向的随机节点的复制节点给原节点的复制节点。A.random = A1.random
     * 3、将形成的聊表拆分成两条链。A-A1-B-B1-C-C1 —> A-B-C 和 A1-B1-C1
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        RandomListNode currentNode = pHead;
        //1、复制每一个节点
        while (currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        //2、为每一个节点添加任意节点指针
        currentNode = pHead;
        while (currentNode != null){
            currentNode.next.random = (currentNode.random == null ? null : currentNode.random.next);
            currentNode = currentNode.next.next;
        }

        //3、拆分为两条链
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
