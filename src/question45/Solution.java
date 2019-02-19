package question45;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/19 16:18
 * Describe: 把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼出的所有数字中最小的一个。
 * 例如，输入数组{3,32,321}，则打印出这3个数能拼成的最小数字321323。
 */
public class Solution {

    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int anArr : numbers) {
            list.add(anArr);
        }
        list.sort((o1, o2) -> { //lambda表达式
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            return s1.compareTo(s2);
        });
        String str = "";
        for(Integer li : list){
            str += li;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(Solution.PrintMinNumber(new int[]{3,32,321}));
    }

}
