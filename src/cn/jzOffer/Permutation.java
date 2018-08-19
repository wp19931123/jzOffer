package cn.jzOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.print(new Permutation().Permutation("bca"));
    }

    ArrayList<String> res;
    boolean[] used;

    public ArrayList<String> Permutation(String str) {
        res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        used = new boolean[str.length()];
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        dfs(chs, new ArrayList<>());

        return res;
    }

    private void dfs(char[] chs, ArrayList<Character> tmp) {
        if (tmp.size() == chs.length) {
            StringBuffer sb = new StringBuffer();
            for (char c : tmp) {
                sb.append(c);
            }
            res.add(sb.toString());
        }

        for (int i = 0; i < chs.length; i++) {
            if (used[i]) {
                continue;
            }
            tmp.add(chs[i]);
            used[i] = true;
            dfs(chs, tmp);
            tmp.remove(tmp.size() - 1);
            used[i] = false;
            //跳过重复的
            while (i < chs.length - 1 && chs[i] == chs[i + 1]) {
                i++;
            }
        }
    }
}
