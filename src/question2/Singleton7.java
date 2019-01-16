package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: DCL(Double Check Lock) 双重检测锁升级版
 */
public class Singleton7 {

    //使用volatile禁止指定重排序
    private static volatile Singleton7 instance = null;

    private Singleton7(){
    }

    public static Singleton7 getInstance() {
        if(instance == null){
            synchronized (Singleton7.class){
                if(instance == null){
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }
}
