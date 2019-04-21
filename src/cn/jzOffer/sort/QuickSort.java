package cn.jzOffer.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 9, 8, 75, 6, 5, 0, 100};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr) {
        partition2(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        if (i >= j) {
            return;
        }
        int index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < index) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = index;
        partition(arr, low, i - 1);
        partition(arr, i + 1, high);
    }

    public static void partition2(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }
        int small = low - 1;  //记录小于区域
        int large = high + 1;  //记录大于区域
        int cur = low;   //当前位置
        int index = arr[low];  //
        while (cur != large) {  //当前数遇到大于区就结束
            if (arr[cur] < index) {
                swap(arr, ++small, cur);
                cur++;
            } else if (arr[cur] == index) {
                cur++;
            } else {
                swap(arr, --large, cur);
            }
        }
        partition2(arr, low, small);
        partition2(arr, large, high);
    }

    public static void partition3(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) {
            return;
        }
        swap(arr, low, high);
        int small = low - 1;
        for (int i = low; i < high; i++) {
            if (arr[i] < arr[high]) {
                small++;
                if (small != i) {
                    swap(arr, small, i);
                }
            }
            small++;
            swap(arr, small, high);
        }


    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
