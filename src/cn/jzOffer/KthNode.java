package cn.jzOffer;

import cn.jzOffer.help.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
 * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {

    int index = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }
            index++;
            if(index == k) {
                return node;
            }
            node = KthNode(pRoot.right,k);
            if(index == k) {
                return node;
            }
        }

        return pRoot;
    }
}
