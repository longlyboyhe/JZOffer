package question21;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 15:43
 * Describe: ��������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 */
public class Solution1 {

    /**
     * ����ԭ���飬�������е�ż���洢��һ���������У���������鿽����ԭ����
     */
    public void reOrderArray(int [] array) {
        int[] tmpArr = new int[array.length];
        int tmpIndex = 0, index = 0;
        for(int i=0;i<array.length;i++){
            if((array[i] & 0x1) == 1){
                array[index++] = array[i];
            } else {
                tmpArr[tmpIndex++] = array[i];
            }
        }
        for(int i = 0;i < tmpIndex;i++){
            array[index++] = tmpArr[i];
        }
    }

}
