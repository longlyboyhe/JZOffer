package question44;

/**
 * @author: zhangocean
 * @Date: 2019/2/19 14:13
 * Describe:数字序列中某一位的数字
 * 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数，求任意第n为对应的数字。
 */
public class Solution {

    /**
     * 思路：这个序列化是有规律的，比如前10位是0-9，是一位数字，前10-99位是90个数，是两位数字，因此可以先判断输入的index是几位数，然后再去相应的位数中找
     * 比如index为19,19是两位数，因此去10-99中找，一位数有10个，所以第19位减去10还剩9位，也就是从10开始的第9位数(1011121314)，4就是第9位数
     */
    public int digitAtIndex(int index){
        if (index < 0){
            return -1;
        }
        int digits = 1;
        while (true){
            if(index < countOfIntegers(digits)){
                return digitAtIndex(index, digits);
            }
            digits++;
        }
    }

    public int digitAtIndex(int index, int digits){
        int wei = digits;
        while (wei-1 != 0){
            int before = countOfIntegers(wei-1);
            index = index-before;
            wei--;
        }
        if(index < 10){
            return index;
        }

        int number = index / digits;
        int weight = index % digits;
        int returnNum = (int) (Math.pow(10, digits-1)+number);
        int num = returnNum;
        for(int i=0;i<digits-weight;i++){
            returnNum = num % 10;
            num /= 10;
        }
        return  returnNum;
    }

    /**
     * 查询几位数一共有多少个数，例如两位数(10-99)，一共有90个数
     */
    public  int countOfIntegers(int digits){
        if(digits == 1){
            return 10;
        }
        return (int) (digits*9*Math.pow(10, digits-1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.digitAtIndex(0));
    }

}
