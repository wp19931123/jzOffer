package cn.jzOffer.sort;

public class HeapSort {
	
	public static void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// 构建一个大根堆
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// 将堆顶记录和当前未经排序子序列的最后一个记录交换
            swap(a, i);
            adjustHeap(a, 0, i - 1);// 将a中前i-1个记录重新调整为大根堆
        }
    }

	/**
	 * 构建大根堆
	 * @param a
	 * @param i
	 * @param len
	 */
	public static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {// 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1])
                ++j; // j为关键字中较大记录的下标
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }
	public static void swap(int[] a, int i) {
		int temp = a[0];
		a[0] = a[i];
		a[i] = temp;
	}

	
}
