package cn.jzOffer;

import cn.jzOffer.help.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintFloor {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) {
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        //层序遍历的思路
        TreeNode n = pRoot;
        TreeNode nLast = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp.add(node.val);
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
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }

        return res;
    }
}
