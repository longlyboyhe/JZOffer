package question3;

import java.util.Arrays;

/**
 * @author: zhangocean
 * @Date: 2019/1/17 21:06
 * Describe: 数组中重复的数组
 * 题目：在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 */
public class ArrayDuplication1 {

    /**
     * 时间复杂度为O(n)，空间复杂度为O(1)
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
