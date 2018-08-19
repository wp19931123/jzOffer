package cn.jzOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.print(new MinNumberInRotateArray().minNumberInRotateArray(arr));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        int min = Integer.MAX_VALUE;
        while (array[left] >= array[right]) {
            //解决[2，1]这种情况
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                //暴力
                for (int i = 0; i < array.length; i++) {
                    min = Math.min(min, array[i]);
                }
                return min;
            } else if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }

        return array[mid];
    }
}
