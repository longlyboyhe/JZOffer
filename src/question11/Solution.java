package question11;

/**
 * @author: zhangocean
 * @Date: 2019/1/19 16:57
 * Describe: 旋转数组的最小数字
 */
public class Solution {

    public static int minNumberInRotateArray(int [] array) {
        int begin=0;
        int end = array.length-1;
        int mid = 0;
        while (array[begin] >= array[end]){
            if(end-begin == 1){
                return array[end];
            }
            mid = (begin+end)/2;
            if(array[mid] >= array[begin]){
                begin = mid;
            } else if(array[mid] <= array[end]){
                end = mid;
            }
        }
        return 0;
    }
}
