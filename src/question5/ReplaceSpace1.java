package question5;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:08
 * Describe: Java提供的替换字符串的方法
 */
public class ReplaceSpace1 {

    public String replaceSpace(StringBuffer str) {
        return String.valueOf(str).replace(" ","%20");
    }

}
