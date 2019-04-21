package cn.jzOffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子
 */
public class HasPath {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        char[] str2 = {'a', 'b', 'c', 'b'};
        System.out.println(new HasPath().hasPath(matrix, 3, 4, str)); //true
        System.out.println(new HasPath().hasPath(matrix, 3, 4, str2)); //false
    }

    //AC
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        boolean[] used = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    if (dfs(matrix, rows, cols, str, i, j, 0, used))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[] matrix, int rows, int cols, char[] str, int row, int col, int index, boolean[] used) {
        if (index == str.length) {
            return true;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        if (matrix[row * cols + col] != str[index] || used[row * cols + col]) {
            return false;
        }
        used[row * cols + col] = true;
        boolean res = dfs(matrix, rows, cols, str, row + 1, col, index + 1, used) || dfs(matrix, rows, cols, str, row - 1, col, index + 1, used)
                || dfs(matrix, rows, cols, str, row, col + 1, index + 1, used) || dfs(matrix, rows, cols, str, row, col - 1, index + 1, used);
        if (!res) {
            used[row * cols + col] = false;
            index--;
        }

        return res;
    }
}
