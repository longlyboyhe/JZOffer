package question43;

/**
 * @author: zhangocean
 * @Date: 2019/2/18 17:07
 * Describe:1~n整数中1出现的次数
 * 题目：输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12,1~12这些整数中包含1的有1、10、11和12，1总共出现了5次。
 */
public class Solution {

    /**
     * 思路参考：https://blog.csdn.net/yi_afly/article/details/52012593
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
