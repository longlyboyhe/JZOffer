package question41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zhangocean
 * @Date: 2019/2/18 14:11
 * Describe: �������е���λ��
 * ��Ŀ����εõ�һ�����������ܵ���λ����������������ж������������֣���ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
public class Solution {

    /**
     * �������������ֳ�һ�������Լ���С�ѣ�����������С�����ҡ�
     * ���Ҫ��ǰ����Ϊż�����������¶���������뵽��С�ѣ���������
     *
     * ����¶������Ӧ�ò��뵽��С���У����Ǹ�����������ĳЩ����ҪС����ʱ�Ͳ��ܱ�֤��С�������������������ѣ�
     * ����취���Ƚ��������뵽�����У�Ȼ�󵯳����ڵ�(�����е������)���ٲ��뵽��С����
     *
     * PriorityQueue��������С�ѣ�������Ȼ���򣬿���ͨ���Զ�����������ʵ����Ϊһ������
     */
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;

    public void Insert(Integer num) {

        if((count & 0x1) == 0){
            maxHeap.offer(num);
            int min = maxHeap.poll();
            minHeap.offer(min);
        } else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if((count & 0x1) == 0){
            int max = maxHeap.peek();
            int min = minHeap.peek();
            return new Double((max+min))/2;
        }
        return new Double(minHeap.peek());

    }

}
