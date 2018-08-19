package cn.jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 6, 7, 6, 5, 4, 4, 4};
        int[] a = new int[1];
        int[] b = new int[1];
        new FindNumsAppearOnce().FindNumsAppearOnce2(arr, a, b);
        System.out.print(a[0] + "  " + b[0]);
    }
    //位运算 O(n)
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int yh = array[0];
        for (int i = 1; i < array.length; i++) {
            yh ^= array[i];
        }
        //找到yh第一个为1的位置
        int index = find1Index(yh);

        //通过该位是0是1来分组，出现一次的两个数必被分到不同的组，各组异或即可

        for (int i = 0; i < array.length; i++) {
            if (indexIs1(array[i], index)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    //因为其他的都出现偶数次，用List可以移除
    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            } else {
                list.remove((Integer) array[i]);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    private boolean indexIs1(int num, int index) {
        for (int i = 0; i < index; i++) {
            num >>= 1;
        }

        return (num & 1) == 1;
    }

    private int find1Index(int yh) {
        for (int i = 0; i < 31; i++) {
            if ((yh & 1) == 1) {
                return i;
            }
            yh >>= 1;
        }
        return -1;
    }
}
