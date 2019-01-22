package question19;

/**
 * @author: zhangocean
 * @Date: 2019/1/22 12:19
 * Describe: 正则表达式匹配
 * 题目：请实现一个函数用来匹配包含’.’和’‘的正则表达式。模式中的字符’.’表示任意一个字符，而’‘表示它前面的字符可以出现任意次(含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串“aaa”与模式“a.a”和“ab*ac*a”匹配，但与“aa.a”和“ab*a”均不匹配。
 */
public class Solution {

    /**
     * 思路：重点分情况讨论匹配遇到pattern的下一个字符是'*'的情况
     *
     * 如果pattern的下一个字符是'*'
     *      1.pattern的当前字符与str的当前字符不匹配，pattern直接后移2位(相当于'*'去掉了pattern的当前不匹配的字符)
     *      2.pattern的当前字符与str的当前字符匹配，有三种情况：
     *                                      ①pattern后移两位(匹配str当前字符0次)
     *                                      ②pattern后移两位，str后移一位(匹配str当前字符一次)
     *                                      ③pattern不动，str后移一位(匹配str当前字符多次)
     * 如果pattern的下一个字符不是'*'
     *      1.pattern的当前字符与str的当前字符匹配，pattern和str都后移一位
     *      2.pattern的当前字符与str的当前字符不匹配，直接返回false
     *
     * 注意：'.'的匹配情况相当于pattern当前字符和str当前字符的匹配
     */
    public boolean match(char[] str, char[] pattern){
        if(str == null && pattern == null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchTwo(str, strIndex, pattern, patternIndex);
    }

    public boolean matchTwo(char[] str, int strIndex, char[] pattern, int patternIndex){
        //str和pattern都到尾，匹配成功
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        //str到尾到时pattern没有到尾，匹配失败
        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        //pattern的下一个字符是'*'
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if(strIndex != str.length && pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchTwo(str, strIndex, pattern,patternIndex+2)//pattern后移两位，视为'*'匹配0个字符
                        || matchTwo(str, strIndex+1,pattern, patternIndex+2)//匹配一个字符
                        || matchTwo(str, strIndex+1, pattern, patternIndex);//‘*’匹配1个，在匹配str中的下一个
            } else{
                return matchTwo(str, strIndex, pattern, patternIndex+2);
            }
        }
        //pattern的下一个不是'*'，且str第一个跟pattern第一个匹配，则都后移1位，否则直接返回false
        if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)){
            return matchTwo(str, strIndex+1, pattern, patternIndex+1);
        }
        return false;
    }

}
