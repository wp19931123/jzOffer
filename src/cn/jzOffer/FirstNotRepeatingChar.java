package cn.jzOffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=len<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.print(new FirstNotRepeatingChar().FirstNotRepeatingChar("abcdedcbaaa"));
    }

    public int FirstNotRepeatingChar(String str) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, true);
            } else {
                map.put(c, false);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (!map.get(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
