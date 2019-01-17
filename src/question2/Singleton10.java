package question2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangocean
 * @Date: 2019/1/16 21:33
 * Describe: �Ǽ�ʱ����
 */
public class Singleton10 {

    //ʹ��Map����������ģʽ
    //�����е���ע�뵽ͳһ�Ĺ���������
    //����ͨ��key�����ָ������
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
