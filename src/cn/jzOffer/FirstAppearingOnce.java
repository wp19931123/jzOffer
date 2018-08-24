package cn.jzOffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符
 */
public class FirstAppearingOnce {

    Map<Character, Boolean> map = new LinkedHashMap();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, true);
        } else {
            map.put(ch, false);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }

        return '#';
    }


    int[] hashtable=new int[256];
    StringBuffer s=new StringBuffer();
    //一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。
    public void Insert2(char ch) {
        s.append(ch);
        hashtable[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce2() {
        char[] ch = s.toString().toCharArray();
        for(char c : ch) {
            if(hashtable[c] == 1) {
                return c;
            }
        }

        return '#';
    }
}
