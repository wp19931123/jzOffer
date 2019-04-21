package cn.jzOffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(2, 2, 3));
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        count = 0;
        used = new boolean[rows * cols];

        return dfs(threshold, rows, cols, 0, 0);
    }

    int count;
    boolean[] used;

    private int dfs(int threshold, int rows, int cols, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || digitSum(i, j) > threshold || used[i * cols + j]) {
            return 0;
        }
        used[i * cols + j] = true;
        count++;
        dfs(threshold, rows, cols, i + 1, j);
        dfs(threshold, rows, cols, i - 1, j);
        dfs(threshold, rows, cols, i, j - 1);
        dfs(threshold, rows, cols, i, j + 1);
        return count;
    }

    private int digitSum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
