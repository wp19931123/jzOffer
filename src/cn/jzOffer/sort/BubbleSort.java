package cn.jzOffer.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {1,2,9,8,75,6,5,0,100};
		arr = bubbleSort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}
	
	public static int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1;i++) { //外循环需要n-1次
			for(int j = 0;j < arr.length - i - 1;j++) { //内循环每次得到一个最大的放在最后
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
		return arr;
	}
		
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

}
