package question12;

/**
 * @author: zhangocean
 * @Date: 2019/1/20 12:24
 * Describe: 矩阵中的路径
 */
public class Solution {

    /**
     * 关于题目的问题：矩阵中可能会存在相同的字符，这是我一开始没有考虑到的
     *
     * 思路：首先这是由一个一维数组通过传入一个行和列抽象成一个二维数组
     *
     * 1.遍历这个二维数组找到与待匹配的字符数组中第一个相同的字符
     * 2.找到了这个相等字符后则递归调用该字符的上、下、左、右字符进行匹配(注意边界判断)
     * 3.如果没有找到则遍历二维数组的下一个元素
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }
        int pathLength = 0;
        boolean[] visited = new boolean[rows * cols];
        //遍历二维数组中的每一个元素
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
            //递归在该字符的上、下、左、右位置上的元素进行下一个字符的匹配
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
