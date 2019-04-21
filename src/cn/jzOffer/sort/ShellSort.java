package cn.jzOffer.sort;

/**
 * 基本原理是，现将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，
 * 然后对各个子序列分别进行直接插入排序，待整个待排序列“基本有序”后，
 * 最后在对所有元素进行一次直接插入排序
 * 希尔排序最好时间复杂度和平均时间复杂度都是（nlogn)，最坏时间复杂度为O(n^2)
 * @author zhu
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {1,2,9,8,75,6,5,0,100};
		shellSort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
    }
}
