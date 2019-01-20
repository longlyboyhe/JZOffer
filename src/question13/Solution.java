package question13;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 14:16
 * Describe: �����˵��˶���Χ
 */
public class Solution {

    /**
     * ���������⣺�����˲�����Ծ�Ż�����в���Ҫ������������
     * ������ֻ��1��100��ʱ�������˴�(0,0)���꿪ʼ�����˶������˶���(0,29)ʱ�˶���Ӧ�ý����ˣ���ʹ(0,30)����λ��С����ֵthreshold
     */
    public static int movingCount(int threshold, int rows, int cols){

        int count = 0;
        boolean[] visited = new boolean[rows*cols];
        count = movingCountCore(threshold, rows, cols, 0, 0, visited, count);

        return count;
    }

    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited, int count){
        if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row*cols+col]){
            return count;
        }
        visited[row*cols+col] = false;
        if((getSum(row)+getSum(col)) <= threshold){
            count++;
            visited[row*cols+col] = true;
            count = movingCountCore(threshold, rows, cols, row+1, col, visited, count);
            count = movingCountCore(threshold, rows, cols, row-1, col, visited, count);
            count = movingCountCore(threshold, rows, cols, row, col+1, visited, count);
            count = movingCountCore(threshold, rows, cols, row, col-1, visited, count);
        }
        return count;
    }

    /**
     * �����������λ֮��
     */
    public static int getSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(10,1,100));
    }

}
