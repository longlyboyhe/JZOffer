package question42;

/**
 * @author: zhangocean
 * @Date: 2019/2/18 15:16
 * Describe: ���������������
 * ��Ŀ������һ���������飬������������Ҳ�и����������е�һ������������������һ�������顣������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
 */
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int sum = array[0];
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]<0){
                if(i == array.length-1){
                    return sum;
                } else if(sum + array[i] > 0){
                    sum += array[i];
                } else {
                    sum = array[++i];

                }
            } else {
                sum += array[i];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {-2,-8,-1,-5,-9};
        System.out.println(solution.FindGreatestSumOfSubArray(array));
    }
}
