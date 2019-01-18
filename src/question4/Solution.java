package question4;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 14:20
 * Describe:
 */
public class Solution {

    public boolean find(int target, int [][] array) {
        int column = array[0].length-1;
        int row = 0;
        while (row < array.length && column >= 0){
            if(target > array[row][column]){
                row++;
            } else if (target < array[row][column]){
                column--;
            } else {
                return true;
            }
        }
        return false;
    }

}
