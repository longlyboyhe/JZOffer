package question10;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 15:00
 * Describe: 쳲���������
 */
public class Solution1 {

    /**
     * Ч�ʵ��µ��㷨
     */
    public static int Fibonacci(int n) {
        if(n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

}
