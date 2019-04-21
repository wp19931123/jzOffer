package cn.jzOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 得到一个数据流中的中位数
 */
public class GetMedian {

    public static void main(String[] args) {
        GetMedian gm = new GetMedian();
        gm.Insert(5);
        gm.Insert(2);
        gm.Insert(3);
        gm.Insert(4);
        System.out.print(gm.GetMedian());
    }

    Queue<Integer> max = new PriorityQueue<>((a, b) -> (b - a));
    Queue<Integer> min = new PriorityQueue<>();
    private int size1 = 0;
    private int size2 = 0;

    public void Insert(Integer num) {
        if (size1 == 0 || num <= max.peek()) {
            if (size1 > size2) {
                min.offer(max.poll());
                max.offer(num);
                size2++;
            } else {
                max.offer(num);
                size1++;
            }
        } else {
            if (size2 > size1) {
                max.offer(min.poll());
                min.offer(num);
                size1++;
            } else {
                min.offer(num);
                size2++;
            }
        }
    }

    public Double GetMedian() {
        int size = size1 + size2;
        if (size == 0) {
            return null;
        }
        if (size % 2 == 0) {
            System.out.println((double) min.peek());
            System.out.println((double) max.peek());
            return ((double) min.peek() + (double) max.peek()) / 2.0;
        } else {
            return size1 > size2 ? (double) max.peek() : (double) min.peek();
        }
    }

    private class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}
