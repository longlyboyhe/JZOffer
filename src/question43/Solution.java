package question43;

/**
 * @author: zhangocean
 * @Date: 2019/2/18 17:07
 * Describe:1~n������1���ֵĴ���
 * ��Ŀ������һ������n����1~n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * ���磬����12,1~12��Щ�����а���1����1��10��11��12��1�ܹ�������5�Ρ�
 */
public class Solution {

    /**
     * ˼·�ο���https://blog.csdn.net/yi_afly/article/details/52012593
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n < 1){
            return 0;
        }
        int count = 0;
        int round = n;
        int weight = 0;
        int base = 1;
        while (round > 0){
            weight = round % 10;
            round /= 10;
            count += round*base;
            if(weight > 1){
                count += base;
            } else if( weight == 1){
                count += n%base+1;
            }
            base *= 10;

        }
        return count;
    }
}
