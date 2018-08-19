package cn.jzOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.print(new VerifySquenceOfBST().VerifySquenceOfBST(arr));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    //递归思路
    private boolean verify(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        int index = l;
        while (index < r && sequence[index] < sequence[r]) {
            index++;
        }
        for (int i = index; i < r; i++) {
            if (sequence[i] < sequence[r]) {
                return false;
            }
        }

        return verify(sequence, l, index - 1) && verify(sequence, index, r - 1);
    }
}
