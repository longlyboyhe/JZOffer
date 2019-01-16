package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: 静态内部类(推荐)
 */
public class Singleton8 {

    private Singleton8(){
    }

    private static class SingletonInstance{
        private static final Singleton8 INSTANCE = new Singleton8();
    }

    public static Singleton8 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
