package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: ����ʽ����(��̬����)
 * ��Ŀ�����һ���࣬����ֻ�����ɸ����һ��ʵ����
 */
public class Singleton1 {

    //���д��������
    private static final Singleton1 instance = new Singleton1();

    //˽�й��캯��
    private Singleton1(){
    }

    //������õ�����������
    public static Singleton1 getInstance() {
        return instance;
    }
}
