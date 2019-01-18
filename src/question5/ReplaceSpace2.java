package question5;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:08
 * Describe: 不使用replace方法
 */
public class ReplaceSpace2 {

    /**
     * 问题一：新开辟一个字符串完成替换
     * 问题二：在原有字符串上进行替换，需要考虑后面字符串移动问题
     *          1.从前往后替换，后面的字符串需要进行多次移动，效率低
     *          2.从后往前替换，首先遍历一遍字符串获得空格的数量，再每次移动时直接将后面的字符串移动到指定位置
     */
    public static String replaceSpace(StringBuffer str) {

        int spaceNum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int oldLength = str.length();
        int newLength = oldLength + 2 * spaceNum;
        int length = newLength-1;
        str.setLength(newLength);
        for(int i=oldLength-1;i>=0;i--){
            if(str.charAt(i) == ' '){
                str.setCharAt(length--, '0');
                str.setCharAt(length--, '2');
                str.setCharAt(length--, '%');
            } else {
                str.setCharAt(length--, str.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We are happy");
        System.out.println(replaceSpace(str));
    }

}
