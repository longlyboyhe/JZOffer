package question44;

/**
 * @author: zhangocean
 * @Date: 2019/2/19 14:13
 * Describe:����������ĳһλ������
 * ��Ŀ��������0123456789101112131415���ĸ�ʽ���л���һ���ַ������С�����������У���5λ����0��ʼ��������5����13λ��1����19λ��4���ȵȡ���дһ���������������nΪ��Ӧ�����֡�
 */
public class Solution {

    /**
     * ˼·��������л����й��ɵģ�����ǰ10λ��0-9����һλ���֣�ǰ10-99λ��90����������λ���֣���˿������ж������index�Ǽ�λ����Ȼ����ȥ��Ӧ��λ������
     * ����indexΪ19,19����λ�������ȥ10-99���ң�һλ����10�������Ե�19λ��ȥ10��ʣ9λ��Ҳ���Ǵ�10��ʼ�ĵ�9λ��(1011121314)��4���ǵ�9λ��
     */
    public int digitAtIndex(int index){
        if (index < 0){
            return -1;
        }
        int digits = 1;
        while (true){
            if(index < countOfIntegers(digits)){
                return digitAtIndex(index, digits);
            }
            digits++;
        }
    }

    public int digitAtIndex(int index, int digits){
        int wei = digits;
        while (wei-1 != 0){
            int before = countOfIntegers(wei-1);
            index = index-before;
            wei--;
        }
        if(index < 10){
            return index;
        }

        int number = index / digits;
        int weight = index % digits;
        int returnNum = (int) (Math.pow(10, digits-1)+number);
        int num = returnNum;
        for(int i=0;i<digits-weight;i++){
            returnNum = num % 10;
            num /= 10;
        }
        return  returnNum;
    }

    /**
     * ��ѯ��λ��һ���ж��ٸ�����������λ��(10-99)��һ����90����
     */
    public  int countOfIntegers(int digits){
        if(digits == 1){
            return 10;
        }
        return (int) (digits*9*Math.pow(10, digits-1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.digitAtIndex(0));
    }

}
