package question15;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 17:03
 * Describe: 二进制中1的个数
 */
public class Solution {

    /**
     * 思路：利用 n & n-1 可以去掉n中最右边的1，并且n中有几个1就会循环几遍
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
