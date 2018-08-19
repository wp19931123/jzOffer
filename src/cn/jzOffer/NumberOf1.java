package cn.jzOffer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    public static void main(String[] args) {
        System.out.print(new NumberOf1().NumberOf1(10));
    }

    public int NumberOf1(int n) {
        int res = 0;
        for(int i = 0;i < 32;i++) {
            if((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }

        return res;
    }
}
