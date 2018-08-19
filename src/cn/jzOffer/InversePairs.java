package cn.jzOffer;

/**
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出
 * 题目保证输入的数组中没有的相同的数字
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.print(new InversePairs().InversePairs(arr));
    }

    //暴力：O(n^2) + O(1)
    public int InversePairs2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    res++;
                }
            }
        }

        return res;
    }

    int res;

    //归并思路 O(nlogn) + O(n)
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        InversePairs(array, 0, array.length-1);

        return res;
    }

    private void InversePairs(int[] array, int begin, int end) {
        int mid = begin + (end - begin) / 2;
        if (begin < end) {
            InversePairs(array, begin, mid);
            InversePairs(array, mid + 1, end);
            merge(array, begin, mid, end);
        }

    }

    private void merge(int[] array, int begin, int mid, int end) {
        int i = begin;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[end - begin + 1];
        while (i <= mid && j <= end) {
            if (array[i] > array[j]) {
                tmp[k++] = array[j++];
                res += (mid - i + 1);
                if (res >= 1000000007) {
                    res %= 1000000007;
                }
            } else {
                tmp[k++] = array[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= end) {
            tmp[k++] = array[j++];
        }
        //排序原数组
        for (int l = 0;l < tmp.length;l++) {
            array[begin + l] = tmp[l];
        }
    }
}
