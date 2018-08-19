package cn.jzOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        new ReOrderArray().reOrderArray(arr);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void reOrderArray(int [] array) {
        if(array == null) {
            return;
        }
        int len = array.length;
        int[] copy = new int[len];
        for(int i = 0;i < len;i++) {
            copy[i] = array[i];
        }
        int index = 0;
        for(int i = 0;i < len;i++) {
            if(copy[i] % 2 == 1) {
                array[index++] = copy[i];
            }
        }
        for(int i = 0;i < len;i++) {
            if(copy[i] % 2 == 0) {
                array[index++] = copy[i];
            }
        }
    }
}
