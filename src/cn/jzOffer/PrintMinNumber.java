package cn.jzOffer;

import java.util.Arrays;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2};
        System.out.print(new PrintMinNumber().PrintMinNumber(arr));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        //排序
        Arrays.sort(str, (a, b) -> (a+b).compareTo(b+a));

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(str[i]);
        }


        return sb.toString();
    }

}
