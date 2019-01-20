package question14;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 16:26
 * Describe: �����ӣ�̰���㷨��
 */
public class Solution2 {

    /**
     * ����̰���㷨��˼�룬�����ܵĽ����Ӽ��ɳ���Ϊ3�Ķ�
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

        int timesOf3 = length / 3;
        if(length - timesOf3*3 == 1){
            timesOf3 = 1;
        }
        int timeOs2 = (length - timesOf3*3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timeOs2));
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCuttingSolution(8));
    }
}
