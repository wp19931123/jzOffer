package cn.jzOffer;

/**
 * 给一个数组，返回它的最大连续子序列的和,长度至少是1
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.print(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(arr));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (curSum < 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            max = max < curSum ? curSum : max;
        }

        return max;
    }
}
