package cn.jzOffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] arr = {-2,-1,0,1,2,3,4,5,6,7,8,9};
        System.out.print(new FindNumbersWithSum().FindNumbersWithSum(arr,8));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int s = array[l] + array[r];
            if (s == sum) {
                res.add(array[l]);
                res.add(array[r]);
                break;
            }else if(s < sum) {
                l++;
            }else{
                r--;
            }
        }

        return res;
    }
}
