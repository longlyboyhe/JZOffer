package question5;

/**
 * @author: zhangocean
 * @Date: 2019/1/18 15:08
 * Describe: �滻�ո�
 * ��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻��%20.
 * ���磬���롰We are happy.�����������we%20are%20happy.����
 */
public class ReplaceSpace1 {

    public String replaceSpace(StringBuffer str) {
        return String.valueOf(str).replace(" ","%20");
    }

}
