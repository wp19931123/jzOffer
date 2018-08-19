package cn.jzOffer;

import cn.jzOffer.help.TreeNode;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的靠前)
 */
public class FindPath {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(1);
        t1.left = t2;
        t2.left = t4;
        t1.right = t3;
        System.out.print(new FindPath().FindPath(t1, 4));


    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<>();

        find(root, target, res, tmp);
        return res;
    }

    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                tmp.add(root.val);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            tmp.add(root.val);
            find(root.left, target - root.val, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
        if (root.right != null) {
            tmp.add(root.val);
            find(root.right, target - root.val, res, tmp);
            tmp.remove(tmp.size() - 1);
        }

    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath2(root.left, target);
        FindPath2(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
}
