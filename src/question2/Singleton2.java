package question2;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: ¶öººÊ½µ¥Àý(¾²Ì¬´úÂë¿é)
 */
public class Singleton2 {

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2(){
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
