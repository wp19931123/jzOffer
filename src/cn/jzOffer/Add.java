package cn.jzOffer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {

    public static void main(String[] args) {
        System.out.print(new Add().Add(8,9));
    }

    //位运算
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            //1：先计算各位相加，不进位
            int tmp = num1 ^ num2;
            //2：记录进位
            num2 = (num1 & num2) << 1;  //只有当对应位都是1时才会产生进位，相当于&
            //3：前两步相加
            num1 = tmp;
        }

        return num1;
    }
}
