package cn.jzOffer.sort;

public class SelectSort {

	public static void main(String[] args) {
		int[] arr = {1,2,9,8,75,6,5,0};
		arr = selectSort(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	public static int[] selectSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length;j++) {
				if(arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

}
