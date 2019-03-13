package question5;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:08
 * Describe: 替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成%20.
 * 例如，输入“We are happy.”，则输出“we%20are%20happy.”。
 */
public class ReplaceSpace1 {

    public String replaceSpace(StringBuffer str) {
        return String.valueOf(str).replace(" ","%20");
    }

}
