package cn.jzOffer;

import cn.jzOffer.help.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的
 */
public class IsSymmetrical {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        System.out.println(new IsSymmetrical().isSymmetrical(t1));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        //定义一个新的根右左遍历方式，与前序遍历对比
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(pRoot);
        s2.push(pRoot);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode left = s1.pop();
            TreeNode right = s2.pop();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            s1.push(left.left); //入栈左孩子
            s1.push(left.right); //入栈右孩子
            s2.push(right.right);//入栈右孩子
            s2.push(right.left);//入栈左孩子
        }

        return true;
    }

    //用队列实现，因为先比较左子树和先比较右子树一样
    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode left, right;
        q1.offer(pRoot.left);
        q2.offer(pRoot.right);
        while (q1 != null && q2 != null) {
            left = q1.poll();
            right = q2.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q1.offer(left.left);
            q1.offer(left.right);
            q2.offer(right.right);
            q2.offer(right.left);
        }
        return true;
    }
}
