package question3;

import java.util.HashSet;

/**
 * @author: zhangocean
 * @Date: 2019/1/17 21:25
 * Describe:
 */
public class ArrayDuplication2 {

    public static void duplicate(int[] arr, int length){
        HashSet set = new HashSet();
        for(int i=0;i<length;i++){
            if(!set.add(arr[i])){
                System.out.println("有重复的数字:" +arr[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        duplicate(arr, arr.length);
    }
}
