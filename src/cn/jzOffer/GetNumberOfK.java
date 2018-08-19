package cn.jzOffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        //找左边界和右边界
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        int first = 0;
        int last = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] >= array[l]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }


        return 0;
    }
}
