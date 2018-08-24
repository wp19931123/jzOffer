package cn.jzOffer;

import cn.jzOffer.help.TreeNode;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintZigZag {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        System.out.println((new PrintZigZag().Print(t1)));
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        //层序遍历的思路
        TreeNode n = pRoot;
        TreeNode nLast = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        boolean flag = true;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);

            if (node.right != null) {
                q.offer(node.right);
                nLast = node.right;
            }
            if (node.left != null) {
                q.offer(node.left);
                nLast = node.left;
            }
            flag ^= true;
            if (!flag) {
                Collections.reverse(tmp);
            }
            flag = !flag;
            if (node == n) {
                n = nLast;
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }

        return res;
    }
}
