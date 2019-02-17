package question40;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 19:17
 * Describe:最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Solution {

    private int current = 0;
    private int[] arr;

    /**
     * 通过建立一个辅助数组(最大堆),最大堆中存放输入n个整数的前k个数，然后每次拿这k个数中的最大数(最大堆取堆中最大值时间复杂度为O(1))跟k中剩下的数比较，若最大值大于k中的数，则交换，并重新保持堆结构
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length || k<=0){
            return list;
        }
        arr = new int[k+1];
        int i;
        for(i=1;i<=k;i++){
            arr[i] = input[i-1];
            current++;
        }
        build();
        for(int j=i;j<input.length;j++){
            if(findMax() > input[j-1]){
                arr[1] = input[j-1];
                percolateDown(1);
            }
        }

        for(int p=1;p<arr.length;p++){
            list.add(p);
        }
        return list;
    }

    public void build(){
        for(int i=current/2;i>0;i--){
            percolateDown(i);
        }
    }

    public int findMax(){
        return arr[1];
    }

    public void percolateDown(int hole){
        int child;
        int tmp = arr[hole];
        for(;hole * 2 <=current;hole *= 2){
            child = hole * 2;
            if(child < current && arr[child+1] > arr[child]){
                child++;
            }
            if(child <= current && arr[hole] < arr[child]){
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        arr[hole] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(solution.GetLeastNumbers_Solution(array, 4));
    }
}
