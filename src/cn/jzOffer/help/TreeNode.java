package cn.jzOffer.help;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    //层序遍历
    public static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode n = root;
        TreeNode nLast = null;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val);
            if (node.left != null) {
                q.offer(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                q.offer(node.right);
                nLast = node.right;
            }
            if (node == n) {
                n = nLast;
                System.out.println();
            }
        }
    }
}
