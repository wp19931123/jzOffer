package cn.jzOffer;

/**
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * n = 13: 1、10、11、12、13
 */
public class NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        for(int i = 1;i <= n;i++) {
            num += numOf1(i);
        }

        return num;
    }

    private int numOf1(int i) {
        int num = 0;
        while(i != 0) {
            if(i % 10 == 1) {
                num++;
            }
            i /= 10;
        }
        return num;
    }

}
