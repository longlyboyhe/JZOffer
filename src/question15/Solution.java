package question15;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 17:03
 * Describe: ��������1�ĸ���
 */
public class Solution {

    /**
     * ˼·������ n & n-1 ����ȥ��n�����ұߵ�1������n���м���1�ͻ�ѭ������
     */
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-9));
    }

}
