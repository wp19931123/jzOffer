package cn.jzOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Find {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}};
        System.out.print(new Find().Find(10, nums));
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = array.length;
        int col = array[0].length;
        int m = 0;
        int n = col - 1;
        while (m < row && n >= 0) {
            if (array[m][n] == target) {
                return true;
            } else if (array[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
