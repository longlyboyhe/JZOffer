package question12;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 12:24
 * Describe: �����е�·��
 */
public class Solution {

    /**
     * ������Ŀ�����⣺�����п��ܻ������ͬ���ַ���������һ��ʼû�п��ǵ���
     *
     * ˼·������������һ��һά����ͨ������һ���к��г����һ����ά����
     *
     * 1.���������ά�����ҵ����ƥ����ַ������е�һ����ͬ���ַ�
     * 2.�ҵ����������ַ�����ݹ���ø��ַ����ϡ��¡������ַ�����ƥ��(ע��߽��ж�)
     * 3.���û���ҵ��������ά�������һ��Ԫ��
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }
        int pathLength = 0;
        boolean[] visited = new boolean[rows * cols];
        //������ά�����е�ÿһ��Ԫ��
        for(int row=0;row<rows;++row){
            for(int col=0;col<cols;++col){
                if(hasPathCore(matrix, rows, cols, str, row, col, visited, pathLength)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col, boolean[] visited, int pathLength){
        if(pathLength >= str.length){
            return true;
        }
        if(row >= rows || col >= cols || row < 0 || col < 0){
            return false;
        }
        boolean hasPath = false;
        if(matrix[row*cols+col] == str[pathLength] && !visited[row*cols+col]){
            visited[row*cols+col] = true;
            pathLength++;
            //�ݹ��ڸ��ַ����ϡ��¡�����λ���ϵ�Ԫ�ؽ�����һ���ַ���ƥ��
            hasPath =  hasPathCore(matrix, rows, cols, str, row+1,col, visited, pathLength)
                    || hasPathCore(matrix, rows, cols, str, row-1,col, visited, pathLength)
                    || hasPathCore(matrix, rows, cols, str, row,col+1, visited, pathLength)
                    || hasPathCore(matrix, rows, cols, str, row,col-1, visited, pathLength);
            if(!hasPath){
                --pathLength;
                visited[row*cols+col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] a1 = {'A','B','C','E','H','J','I','G','S','F','C','S','L','O','P','Q','A','D','E','E','M','N','O','E','A','D','I','D','E','J','F','M','V','C','E','I','F','G','G','S'};
        char[] a2 = {'S','G','G','F','I','E','C','V','A','A','S','A','B','C','E','H','J','I','G','Q','E','M'};
        System.out.println(hasPath(a1,5,8,a2));
    }

}
