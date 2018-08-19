package cn.jzOffer;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 */
public class LeftRotateString {

    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0) {
            return "";
        }
        n %= str.length();
        char[] chs = str.toCharArray();
        rotate(chs,0,n-1);
        rotate(chs,n,chs.length-1);
        rotate(chs,0,chs.length-1);
        StringBuffer sb = new StringBuffer();
        for(char c : chs) {
            sb.append(c);
        }

        return sb.toString();
    }

    private void rotate(char[] chs, int a, int b) {
        while(a < b) {
            char tmp = chs[a];
            chs[a++] = chs[b];
            chs[b--] = tmp;
        }
    }
}
