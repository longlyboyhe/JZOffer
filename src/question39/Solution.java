package question39;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 16:45
 * Describe:数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {

    /**
     * 通过这种算法最后获得的now一定是数组中出现次数最多的。然后在判断该数是否大于数组的一半。时间复杂度为O(N)
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
