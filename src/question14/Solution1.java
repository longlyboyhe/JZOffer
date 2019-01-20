package question14;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 15:59
 * Describe: 剪绳子（动态规划）
 */
public class Solution1 {

    /**
     * 题目：给你一根长度为n的绳子，请把绳子剪成m段(m、n都是整数，n>1并且m>1)，每段绳子的长度记为k[0],k[1],...,k[m]。
     * 请问k[0]*k[1]*...k[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长为2,3,3的三段，此时得到的最大乘积是18
     */
    public static int maxProductAfterCuttingSolution(int length){
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }
        int[] products = new int[length+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for(int i=4;i<=length;i++){
            int max = 0;
            for(int j=1;j<=i/2;j++){
                int product = products[j]*products[i-j];
                if(max < product){
                    max = product;
                }
            }
            products[i] = max;
        }

        return products[length];
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCuttingSolution(8));
    }
}
