package question46;

/**
 * @author: zhangocean
 * @Date: 2019/2/19 16:53
 * Describe: �����ַ�����ַ���
 * ��Ŀ������һ�����֣����ǰ������¹����������Ϊ�ַ�����0����ɡ�a����1����ɡ�b����������11����ɡ�l����������25����ɡ�z����һ�����ֿ����ж�����롣
 * ���磬12258��5�ַ��룬�ֱ��ǡ�bccfi������bwfi������bczi������mcfi���͡�mzi��������ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 */
public class Solution {

        public static int getTranslationCount(int number){
            if(number<0) {
                return 0;
            }
            if(number==1) {
                return 1;
            }
            return getTranslationCount(Integer.toString(number));
        }
        //��̬�滮�����ҵ�����㡣
        //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
        //���r-2��r-1�ܹ�������ַ�����g(r-2,r-1)=1������Ϊ0
        public static int getTranslationCount(String number) {
            int f1 = 0,f2 = 1,g = 0;
            int temp;
            for(int i=number.length()-2;i>=0;i--){
                if(Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26) {
                    g = 1;
                }
                else {
                    g = 0;
                }
                temp = f2;
                f2 = f2+g*f1;
                f1 = temp;
            }
            return f2;
        }
        public static void main(String[] args){
            System.out.println(getTranslationCount(-10));  //0
            System.out.println(getTranslationCount(1234));  //3
            System.out.println(getTranslationCount(12258)); //5
        }
}
