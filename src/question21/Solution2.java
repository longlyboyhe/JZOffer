package question21;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 14:46
 * Describe:调整数组顺序使奇数位于偶数前面
 */
public class Solution2 {

    /**
     * 定义两个指针分别指向第一个元素和最后一个元素，移动两指针，使第一个指针指向第一个偶数，第二个指针指向最后一个奇数，交换奇数与偶数的位置
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
