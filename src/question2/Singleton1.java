package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: ����ʽ����
 */
public class Singleton1 {

    //���д��������
    private static Singleton1 instance = new Singleton1();

    //˽�й��캯��
    private Singleton1(){
    }

    //������õ�����������
    public Singleton1 getInstance() {
        return instance;
    }
}
