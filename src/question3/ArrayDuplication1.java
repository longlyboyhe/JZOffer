package question3;

import java.util.Arrays;

/**
 * @author: zhangocean
 * @Date: 2019/1/17 21:06
 * Describe: �������ظ�������
 * ��Ŀ����һ������Ϊn����������������ֶ���0~n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3��
 */
public class ArrayDuplication1 {

    /**
     * ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)
     */
    public static boolean duplicate(int numbers[],int length) {
        int k;
        for(int i=0;i<length;i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    return true;
                }
                k = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[k] = k;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(duplicate(arr, arr.length));
    }
}
