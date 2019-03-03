package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: 饿汉式单例(静态常量)
 * 题目：设计一个类，我们只能生成该类的一个实例。
 */
public class Singleton1 {

    //类中创建类对象
    private static final Singleton1 instance = new Singleton1();

    //私有构造函数
    private Singleton1(){
    }

    //公共获得单例变量方法
    public static Singleton1 getInstance() {
        return instance;
    }
}
