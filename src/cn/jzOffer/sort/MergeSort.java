package cn.jzOffer.sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 8, 75, 6, 5, 0, 100};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void mergeSort(int[] arr, int p, int r) {
        int q = (p + r) >> 1;
        if (p < r) {
            mergeSort(arr, p, q);  //左半排序
            mergeSort(arr, q + 1, r);  //左半排序
            merge(arr, p, q, r);  //合并
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int[] res = new int[r - p + 1];
        int k = 0;
        int i = p;
        int j = q + 1;
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
            }
        }
        while (i <= q) {
            res[k++] = arr[i++];
        }
        while (j <= r) {
            res[k++] = arr[j++];
        }

        //赋值回去
        for (int a = 0; a < r - p + 1; a++) {
            arr[a + p] = res[a];
        }
    }

}
