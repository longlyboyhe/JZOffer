package question19;

/**
 * @author: zhangocean
 * @Date: 2019/1/22 12:19
 * Describe: ������ʽƥ��
 * ��Ŀ����ʵ��һ����������ƥ�������.���͡�����������ʽ��ģʽ�е��ַ���.����ʾ����һ���ַ�����������ʾ��ǰ����ַ����Գ��������(��0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
 * ���磬�ַ�����aaa����ģʽ��a.a���͡�ab*ac*a��ƥ�䣬���롰aa.a���͡�ab*a������ƥ�䡣
 */
public class Solution {

    /**
     * ˼·���ص���������ƥ������pattern����һ���ַ���'*'�����
     *
     * ���pattern����һ���ַ���'*'
     *      1.pattern�ĵ�ǰ�ַ���str�ĵ�ǰ�ַ���ƥ�䣬patternֱ�Ӻ���2λ(�൱��'*'ȥ����pattern�ĵ�ǰ��ƥ����ַ�)
     *      2.pattern�ĵ�ǰ�ַ���str�ĵ�ǰ�ַ�ƥ�䣬�����������
     *                                      ��pattern������λ(ƥ��str��ǰ�ַ�0��)
     *                                      ��pattern������λ��str����һλ(ƥ��str��ǰ�ַ�һ��)
     *                                      ��pattern������str����һλ(ƥ��str��ǰ�ַ����)
     * ���pattern����һ���ַ�����'*'
     *      1.pattern�ĵ�ǰ�ַ���str�ĵ�ǰ�ַ�ƥ�䣬pattern��str������һλ
     *      2.pattern�ĵ�ǰ�ַ���str�ĵ�ǰ�ַ���ƥ�䣬ֱ�ӷ���false
     *
     * ע�⣺'.'��ƥ������൱��pattern��ǰ�ַ���str��ǰ�ַ���ƥ��
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
        //str��pattern����β��ƥ��ɹ�
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        //str��β��ʱpatternû�е�β��ƥ��ʧ��
        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        //pattern����һ���ַ���'*'
        if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*'){
            if(strIndex != str.length && pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchTwo(str, strIndex, pattern,patternIndex+2)//pattern������λ����Ϊ'*'ƥ��0���ַ�
                        || matchTwo(str, strIndex+1,pattern, patternIndex+2)//ƥ��һ���ַ�
                        || matchTwo(str, strIndex+1, pattern, patternIndex);//��*��ƥ��1������ƥ��str�е���һ��
            } else{
                return matchTwo(str, strIndex, pattern, patternIndex+2);
            }
        }
        //pattern����һ������'*'����str��һ����pattern��һ��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
        if((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)){
            return matchTwo(str, strIndex+1, pattern, patternIndex+1);
        }
        return false;
    }

}
