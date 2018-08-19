package cn.jzOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {

    public static void main(String[] args) {
        System.out.print(new Power().Power(2,-2));
    }

    public double Power(double base, int exponent) {
        double res = 1;
        if (exponent == 0) {
            return 1;
        }
        int flag = 1;
        if (exponent < 0) {
            exponent = -exponent;
            flag = -1;
        }
        double half = Power(base, exponent / 2);
        if (exponent % 2 == 0) {
            res = half * half;
        } else {
            res = base * half * half;
        }

        return flag == 1 ? res : 1 / res;
    }
}
