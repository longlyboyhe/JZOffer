package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: 饿汉式单例
 */
public class Singleton1 {

    //类中创建类对象
    private static Singleton1 instance = new Singleton1();

    //私有构造函数
    private Singleton1(){
    }

    //公共获得单例变量方法
    public Singleton1 getInstance() {
        return instance;
    }
}
