package question14;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 15:59
 * Describe: �����ӣ���̬�滮��
 */
public class Solution1 {

    /**
     * ��Ŀ������һ������Ϊn�����ӣ�������Ӽ���m��(m��n����������n>1����m>1)��ÿ�����ӵĳ��ȼ�Ϊk[0],k[1],...,k[m]��
     * ����k[0]*k[1]*...k[m]���ܵ����˻��Ƕ��٣����磬�����ӵĳ�����8ʱ�����ǰ������ɳ�Ϊ2,3,3�����Σ���ʱ�õ������˻���18
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
