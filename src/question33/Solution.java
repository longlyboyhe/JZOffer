package question33;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 15:09
 * Describe:二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 例如，输入数组{5,7,6,9,11,10,8}，则返回true，因为这个整数序列是一颗二叉搜索树的后序遍历结果。如果输入的数组是{7,4,6,5}，则由于没有哪颗二叉搜索树的后序遍历结果是这个序列，因此返回false。
 */
public class Solution {

    /**
     * 思路：根据后序遍历的性质，最后一个节点为根节点，根节点前面的数分为两部分。第一部分小于根节点为左子树，第二部分大于根节点为右子树
     *
     * 递归判断，如果第二部分有小于根节点的则说明这不是树的后续遍历
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null){
            return false;
        }

        return VerifySquenceOfBST(sequence, 0, sequence.length);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int begin, int length){
        if(length == 0){
            return false;
        }
        int root = sequence[length-1];
        int i=begin;
        for(;i<length-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<length-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        boolean left = true;
        if(i>0){
            left = VerifySquenceOfBST(sequence, 0, i);
        }
        boolean right = true;
        if(i < length-1){
            right = VerifySquenceOfBST(sequence, i,  length-i-1);
        }
        return left && right;
    }

}