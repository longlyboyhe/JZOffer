package question21;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 14:46
 * Describe:��������˳��ʹ����λ��ż��ǰ��
 */
public class Solution2 {

    /**
     * ��������ָ��ֱ�ָ���һ��Ԫ�غ����һ��Ԫ�أ��ƶ���ָ�룬ʹ��һ��ָ��ָ���һ��ż�����ڶ���ָ��ָ�����һ������������������ż����λ��
     */
    public void reOrderArray(int [] array) {
        int begin = 0, end = array.length-1;
        while (begin < end){
            while (begin < end && (array[begin] & 0x1) != 0){
                begin++;
            }
            while (begin < end && (array[end] & 0x1) != 1){
                end--;
            }
            if(begin < end){
                int tmp = array[begin];
                array[begin] = array[end];
                array[end] = tmp;
            }
        }
    }

}
