package question10;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 15:00
 * Describe:斐波那契数列
 */
public class Solution2 {

    /**
     * 面试官希望看到的优化
     */
    public static int Fibonacci(int n) {
        int a=0,b=1,c=0;
        if(n == 0){
            return a;
        } else if (n == 1){
            return b;
        }
        for(int i=0;i<n-1;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(32));
    }
}
