package question16;

/**
 * @author: zhangocean
 * @Date: 2019/1/21 13:37
 * Describe: ��ֵ�������η�
 */
public class Solution {

    /**
     * ���⣺����С��0��ָ��С�ڵ���0���������
     *
     * ����һ������n�η�������n/2�η�
     */
    public static double power(double base, int exponent) throws Exception {
        boolean isNegative = false;
        if(base < 0 && exponent < 0){
            throw new Exception("pow(0,0)");
        }
        if(exponent == 0){
            return 1;
        }
        if(base == 0){
            return 0;
        }
        if(exponent < 0){
            isNegative = true;
            exponent = -exponent;
        }
        double result = powerWithExp(base, exponent);
        if(isNegative == true){
            result = 1.0/result;
        }
        return result;
    }

    public static double powerWithExp(double base, int exponent){
        if(exponent == 0){
            return 1;
        }
         if(exponent == 1){
            return base;
         }
         double result = powerWithExp(base, exponent >> 1);
         result *= result;
         if(exponent % 2 == 1){
             result = result * base;
         }
         return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(power(2.0,3));
    }

}
