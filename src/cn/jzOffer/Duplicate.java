package cn.jzOffer;

import java.util.Arrays;

/**
 * 长度为n的数组里的所有数字都在0到n-1的范围内
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字
 */
public class Duplicate {

    //排序
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
            return false;
        }
        Arrays.sort(numbers);
        for(int i = 0;i < length-1;i++) {
            if(numbers[i] == numbers[i+1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }

        return false;
    }

    //记录出现过
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        boolean[] used = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (used[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            used[numbers[i]] = true;
        }

        return false;
    }
}
