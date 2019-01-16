package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: DCL(Double Check Lock) 双重检测锁
 */
public class Singleton6 {

    private static Singleton6 instance = null;

    private Singleton6(){
    }

    //可能会存在创建对象时出现指定重排序导致线程不安全问题
    //创建对象过程：1.堆中分配内存
    //              2.初始化对象
    //              3.将对象引用指向该片内存
    //过程2和过程3会出现指令重排序
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
