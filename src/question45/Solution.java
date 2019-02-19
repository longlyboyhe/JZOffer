package question45;

import java.util.ArrayList;

/**
 * @author: zhangocean
 * @Date: 2019/2/19 16:18
 * Describe: �������ų���С����
 * ��Ŀ������һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ����������������С��һ����
 * ���磬��������{3,32,321}�����ӡ����3������ƴ�ɵ���С����321323��
 */
public class Solution {

    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int anArr : numbers) {
            list.add(anArr);
        }
        list.sort((o1, o2) -> { //lambda���ʽ
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
