package cn.jzOffer;

import java.util.Arrays;

/**
 * 52个普通牌，4个大小王
 * 拿五张牌求组成顺子的概率，可以认为大小王是0
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] arr = {1,0,0,5,7};
        System.out.print(new IsContinuous().isContinuous(arr));
    }

    //数组里存的是输入数字
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return false;
        }

        //排序
        Arrays.sort(numbers);
        //求0的个数
        int numOf0 = 0;
        while (numbers[numOf0] == 0) {
            numOf0++;
        }
        //数组的相邻数字之间的间隙
        int numOfGap = 0;
        int small = numOf0;
        int big = small + 1;
        while(big < numbers.length) {
            if(numbers[small] == numbers[big]) {
                return false;
            }
            numOfGap += numbers[big]- numbers[small] - 1;
            small++;
            big++;
        }

        return numOfGap <= numOf0;
    }
}
