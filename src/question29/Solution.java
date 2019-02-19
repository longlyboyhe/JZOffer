package question29;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/13 20:10
 * Describe: ˳ʱ���ӡ����
 * ��Ŀ������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
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
        //��������
        for(int i=start;i<=endX;i++){
            printResult.add(matrix[start][i]);
        }
        //��������
        if(endY > start){
            for(int i=start + 1;i<=endY;i++){
                printResult.add(matrix[i][endX]);
            }
        }
        //��������
        if(endX > start && endY > start){
            for(int i=endX-1;i>=start;i--){
                printResult.add(matrix[endY][i]);
            }
        }
        //��������
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
