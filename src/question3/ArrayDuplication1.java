package question3;

/**
 * @author: zhangocean
 * @Date: 2019/1/17 21:06
 * Describe: 找出重复的数，时间复杂度为O(n)，空间复杂度为O(1)
 */
public class ArrayDuplication1 {

    public static boolean duplicate(int numbers[],int length) {
        for(int i=0;i<length;i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    return true;
                }
                swapReference(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    public static void swapReference(int[] arr, int i, int j){
        int k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        System.out.println(duplicate(arr, arr.length));
    }
}
