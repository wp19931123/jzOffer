package cn.jzOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3
 * 最大值分别为{4,4,6,6,6,5}
 */
public class MaxInWindows {
    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(new MaxInWindows().maxInWindows(num, 3));
    }

    //双端队列O(N)
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int begin = -size;  //保存
        ArrayDeque<Integer> q = new ArrayDeque<>();  //双端队列
        for (int i = 0; i < num.length; i++) {
            begin++;
            if (q.isEmpty())
                q.add(i);
            else if (begin > q.peekFirst())   //判断当前最大值是否过期
                q.pollFirst();

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])  //将前面小于等于当前数的索引移除
                q.pollLast();
            q.add(i);  //当前索引入队
            if (begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }

    //暴力 时间复杂度：O(N*size)
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size <= 0 || num.length == 0) {
            return list;
        }
        int begin = 0;  //窗口最左位置
        int end = begin + size; //窗口最右位置
        int curMax;   //当前最大值
        while (end <= num.length) {
            curMax = num[begin];
            for (int i = begin; i < end; i++) {
                if (num[i] > curMax) {
                    curMax = num[i];
                }
            }
            list.add(curMax);
            begin++;
            end++;
        }
        return list;
    }
}
