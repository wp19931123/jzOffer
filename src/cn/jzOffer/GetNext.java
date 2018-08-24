package cn.jzOffer;

import cn.jzOffer.help.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) {
            return null;
        }
        TreeLinkNode p = pNode;
        if(p.right != null) {
            //求右子树的最左节点
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }
        //右子树不存在，下一个节点就是往上寻找第一个是其父节点的左子树的节点，返回其父节点
        while(p != null && p.next != null && p != p.next.left) {
            p = p.next;
        }

        return p.next;
    }
}
