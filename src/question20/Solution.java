package question20;

/**
 * @author: zhangocean
 * @Date: 2019/1/22 13:57
 * Describe: 表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、“1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是。
 */
public class Solution {
    int index = 0;

    public boolean isNumeric(char[] str) {
        if(str == null){
            return false;
        }
        boolean flag = scanInteger(str);

        if(index < str.length && str[index] == '.'){
            index++;
            flag = scanUnsignedInteger(str);
        }

        if(index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = scanInteger(str);
        }
        return flag && index == str.length;
    }

    public boolean scanInteger(char[] str){
        if(index < str.length && (str[index] == '+' || str[index] == '-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    public boolean scanUnsignedInteger(char[] str){
        int begin = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        //判断是否有整数
        return begin < index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars = {'1','e','0','1','e','1'};
        System.out.println(solution.isNumeric(chars));;
    }

}
