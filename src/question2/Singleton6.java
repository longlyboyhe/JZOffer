package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: DCL(Double Check Lock) ˫�ؼ����
 */
public class Singleton6 {

    private static Singleton6 instance = null;

    private Singleton6(){
    }

    //���ܻ���ڴ�������ʱ����ָ�����������̲߳���ȫ����
    //����������̣�1.���з����ڴ�
    //              2.��ʼ������
    //              3.����������ָ���Ƭ�ڴ�
    //����2�͹���3�����ָ��������
    public static Singleton6 getInstance() {
        if(instance == null){
            synchronized (Singleton6.class){
                if(instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
