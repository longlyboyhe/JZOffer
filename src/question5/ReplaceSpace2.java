package question5;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:08
 * Describe: ��ʹ��replace����
 */
public class ReplaceSpace2 {

    /**
     * ����һ���¿���һ���ַ�������滻
     * ���������ԭ���ַ����Ͻ����滻����Ҫ���Ǻ����ַ����ƶ�����
     *          1.��ǰ�����滻��������ַ�����Ҫ���ж���ƶ���Ч�ʵ�
     *          2.�Ӻ���ǰ�滻�����ȱ���һ���ַ�����ÿո����������ÿ���ƶ�ʱֱ�ӽ�������ַ����ƶ���ָ��λ��
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
