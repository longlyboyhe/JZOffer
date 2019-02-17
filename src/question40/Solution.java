package question40;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/17 19:17
 * Describe:��С��k����
 * ��Ŀ������n���������ҳ�������С��k���������磬����4��5��1��6��2��7��3��8��8�����֣�����С��4��������1��2��3��4��
 */
public class Solution {

    private int current = 0;
    private int[] arr;

    /**
     * ͨ������һ����������(����),�����д������n��������ǰk������Ȼ��ÿ������k�����е������(����ȡ�������ֵʱ�临�Ӷ�ΪO(1))��k��ʣ�µ����Ƚϣ������ֵ����k�е������򽻻��������±��ֶѽṹ
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
