package cn.jzOffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字,如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.print(new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution(array));
    }

    //O(n)
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //摩尔投票
        int cnt = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                res = array[i];
            } else if (res == array[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        if (cnt == 0) {
            return 0;
        }
        //验证
        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                cnt++;
            }
        }

        return cnt > array.length / 2 ? res : 0;
    }
}
