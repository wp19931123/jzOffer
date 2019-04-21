package cn.jzOffer.sort;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void insertSort(int[] arr) {
		for(int i = 1; i < arr.length;i++) {
			int tmp = arr[i];  //记录新元素
			int j = i;
			if(arr[j - 1] > tmp) { //当前数比前面已排序的最大的还大
				while(j >= 1 && arr[j - 1] > tmp) {
					arr[j] = arr[j - 1]; //新位置等于最大的，新数插入到前面
					j--;
				}
			}
			arr[j] = tmp;  //新元素插入到j位置
		}
	}

}
