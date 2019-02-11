package question21;

/**
 * @author: zhangocean
 * @Date: 2019/2/11 15:43
 * Describe: 调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Solution1 {

    /**
     * 遍历原数组，并将其中的偶数存储到一个新数组中，最后将新数组拷贝回原数组
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
