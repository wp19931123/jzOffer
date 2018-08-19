package cn.jzOffer;


import cn.jzOffer.help.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode.print(new ReConstructBinaryTree().reConstructBinaryTree(pre, in));

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int b1, int e1, int b2, int e2) {
        if (b1 > e1 || b2 > e2) {
            return null;
        }
        TreeNode root = new TreeNode(pre[b1]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[b1]) {
                int len = i - b2;
                root.left = reConstructBinaryTree(pre, in, b1 + 1, b1 + len, b2, i);
                root.right = reConstructBinaryTree(pre, in, b1 + len + 1, e1, i + 1, e2);
            }
        }

        return root;
    }
}
