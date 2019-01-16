package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: ����ʽ����(�̼߳�װ��ȫ)
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5(){
    }

    public static Singleton5 getInstance() {
        if(instance == null){
            synchronized (Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
