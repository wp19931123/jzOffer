package cn.jzOffer;

import java.util.LinkedList;

/**
 * 环形队列
 * 小朋友的编号是从0到n-1,随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友出队，
 * 从他的下一个小朋友继续从0开始报数，最后剩哪一个
 */
public class LastRemaining_Solution {

    //公式法-约瑟夫环问题
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    //用数组来模拟一个环
    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1;  //表示数组下标
        int step = 0; //表示走的步数
        int count = n;  //表示剩余元素个数
        while (count > 0) {
            i++;
            if (i >= n)
                i = 0;
            if (array[i] == -1)
                continue;
            step++;
            if (step == m) {
                array[i] = -1;
                count--;
                step = 0;
            }
        }

        return i;
    }

    public int LastRemaining_Solution3(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();  //关键
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}
