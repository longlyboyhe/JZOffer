package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: 懒汉式单例(线程安全)
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){
    }

    public static synchronized Singleton4 getInstance() {
        if(instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
