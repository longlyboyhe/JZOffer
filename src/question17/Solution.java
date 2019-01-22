package question17;

/**
 * @author: zhangocean
 * @Date: 2019/1/21 14:28
 * Describe: 打印从1到最大的n位数
 */
public class Solution {

    public static void printToMaxOfDigits(int n){
        if(n < 1){
            return;
        }
        char[] str = new char[n];
        for(int i=0;i<10;i++){
            str[0] = (char)('0' + i);
            printToMaxOfDigitsRecursively(str, n, 0);
        }
    }

    public static void printToMaxOfDigitsRecursively(char[] str, int length, int index){
        if(length-1 == index){
            printNum(str);
            return;
        }
        for(int i=0;i<10;i++){
            str[index+1] = (char)(i+'0');
            printToMaxOfDigitsRecursively(str, length, index+1);
        }
    }

    public static void printNum(char[] num){
        boolean isReady = false;
        for(int i=0;i<num.length;i++){
            if(!isReady && num[i] == '0'){
                continue;
            }
            isReady = true;
            System.out.print(num[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printToMaxOfDigits(5);

    }
}
