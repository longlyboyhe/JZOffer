package question39;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 16:45
 * Describe:�����г��ִ�������һ�������
 * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class Solution {

    /**
     * ͨ�������㷨����õ�nowһ���������г��ִ������ġ�Ȼ�����жϸ����Ƿ���������һ�롣ʱ�临�Ӷ�ΪO(N)
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int now = array[0];
        for(int i=1;i<array.length;i++){
            if(now != array[i]){
                if(count == 1){
                    now = array[i];
                } else {
                    count--;
                }

            } else {
                count++;
            }
        }
        if(checkMoreThanHalf(now, array)){
            return now;
        }
        return 0;
    }

    boolean checkMoreThanHalf(int number, int[] array){
        int times = 0;
        for(int i=0;i<array.length;i++){
            if(number == array[i]){
                times++;
            }
        }
        if(times * 2 <= array.length){
            return false;
        }
        return true;
    }

}
