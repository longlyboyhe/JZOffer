package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: 懒汉式单例(线程不安全)
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){
    }

    public static Singleton3 getInstance() {
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
