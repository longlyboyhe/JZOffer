package question2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: 登记时单例
 */
public class Singleton10 {

    //使用Map容器管理单例模式
    //将所有单例注入到统一的管理容器中
    //后续通过key来获得指定单例
    private static Map<String, Object> map = new HashMap<>();

    private Singleton10(){
    }

    public static void registerService(String key, Object instance){
        if(!map.containsKey(key)){
            map.put(key, instance);
        }
    }

    public static Object getService(String key){
        return map.get(key);
    }

}
