package question33;

/**
 * @author: zhangocean
 * @Date: 2019/2/16 15:09
 * Describe:�����������ĺ����������
 * ��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ�����������������򷵻�true�����򷵻�false���������������������������ֶ�������ͬ��
 * ���磬��������{5,7,6,9,11,10,8}���򷵻�true����Ϊ�������������һ�Ŷ����������ĺ�������������������������{7,4,6,5}��������û���ĿŶ����������ĺ�����������������У���˷���false��
 */
public class Solution {

    /**
     * ˼·�����ݺ�����������ʣ����һ���ڵ�Ϊ���ڵ㣬���ڵ�ǰ�������Ϊ�����֡���һ����С�ڸ��ڵ�Ϊ���������ڶ����ִ��ڸ��ڵ�Ϊ������
     *
     * �ݹ��жϣ�����ڶ�������С�ڸ��ڵ����˵���ⲻ�����ĺ�������
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