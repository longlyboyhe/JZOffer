package question29;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 20:10
 * Describe: 顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        ArrayList<Integer> printResult = new ArrayList<>();
        while (start * 2 < rows && start * 2 < columns){
            printMatrixCircle(matrix, start++, rows, columns, printResult);
        }

        return printResult;
    }

    public void printMatrixCircle(int[][] matrix, int start, int rows, int columns, ArrayList<Integer> printResult){
        int endX = columns - start -1;
        int endY = rows - start - 1;
        //从左往右
        for(int i=start;i<=endX;i++){
            printResult.add(matrix[start][i]);
        }
        //从上往下
        if(endY > start){
            for(int i=start + 1;i<=endY;i++){
                printResult.add(matrix[i][endX]);
            }
        }
        //从右往左
        if(endX > start && endY > start){
            for(int i=endX-1;i>=start;i--){
                printResult.add(matrix[endY][i]);
            }
        }
        //从下往上
        if(endX > start && endY > start){
            for (int i=endY-1;i>start;i--){
                printResult.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        Solution solution = new Solution();
        System.out.println(solution.printMatrix(matrix));
    }
}
