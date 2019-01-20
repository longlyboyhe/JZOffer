package question13;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 14:16
 * Describe: 机器人的运动范围
 */
public class Solution {

    /**
     * 遇到的问题：机器人不会跳跃着活动，所有不需要遍历所有坐标
     * 例：当只有1行100列时，机器人从(0,0)坐标开始向右运动，当运动到(0,29)时运动就应该结束了，即使(0,30)的数位和小于阈值threshold
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
     * 计算坐标的数位之和
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
