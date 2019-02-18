package question41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zhangocean
 * @Date: 2019/2/18 14:11
 * Describe: 数据流中的中位数
 * 题目：如何得到一个数据流汇总的中位数？如果从数据流中读入奇数个数字，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution {

    /**
     * 将整个输入流分成一个最大堆以及最小堆，最大堆在左最小堆在右。
     * 如果要当前总数为偶数个，即将新读入的数插入到最小堆，否则最大堆
     *
     * 如果新读入的数应该插入到最小堆中，但是该数比最大堆中某些数还要小，这时就不能保证最小堆中所有数都大于最大堆？
     * 解决办法：先将该数插入到最大堆中，然后弹出根节点(最大堆中的最大数)，再插入到最小堆中
     *
     * PriorityQueue本身是最小堆，按照自然排序，可以通过自定义排序器来实现其为一个最大堆
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
