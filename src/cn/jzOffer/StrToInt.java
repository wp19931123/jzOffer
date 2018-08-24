package cn.jzOffer;

/**
 * Integer.valueOf(string)
 */
public class StrToInt {

    public static void main(String[] args) {
        System.out.print(new StrToInt().StrToInt("-125"));
    }

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int flag = 0;
        char[] ch = str.toCharArray();
        if (ch[0] == '-' || ch[0] == '+') {
            flag = 1;
        }
        int sum = 0;
        for (int i = flag; i < ch.length; i++) {
            if(ch[i] < 48 || ch[i] > 57) {
                return 0;
            }
            sum  = 10 * sum + ch[i] - 48;
        }

        return ch[0] == '-' ? -sum : sum;
    }
}
