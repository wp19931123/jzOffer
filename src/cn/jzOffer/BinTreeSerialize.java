package cn.jzOffer;

import cn.jzOffer.help.TreeNode;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class BinTreeSerialize {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        BinTreeSerialize b = new BinTreeSerialize();
        String str = b.Serialize(t1);
        System.out.println(str);
        TreeNode node = b.Deserialize(str);
        TreeNode.print(node);


    }

    StringBuilder sb = new StringBuilder();

    String Serialize(TreeNode root) {
        if (root == null) {
            sb.append("_#");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append("#");
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] s = str.split("#");
        return Deserialize(s);
    }

    int index = -1;

    private TreeNode Deserialize(String[] s) {
        index++;
        if (!s[index].equals("_")) {
            TreeNode node = new TreeNode(Integer.valueOf(s[index]));
            node.left = Deserialize(s);
            node.right = Deserialize(s);
            return node;
        }

        return null;
    }
}
