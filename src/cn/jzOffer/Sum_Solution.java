package cn.jzOffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {

    public int Sum_Solution(int n) {
        //用递归
        int sum = n;
        //利用&&的短路特性，当n==0时跳出递归
        boolean ans = n > 0 && (sum += Sum_Solution(n-1)) > 0;
        return sum;
    }
}
