package question4;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 14:20
 * Describe:二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
