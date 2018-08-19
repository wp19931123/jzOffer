package cn.jzOffer;

/**
 * student. a am I
 * I am a student.
 */
public class ReverseSentence {

    public static void main(String[] args) {
        System.out.print(new ReverseSentence().ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chs = str.toCharArray();
        reverse(chs, 0, chs.length - 1);
        int pre = -1;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ' || chs[i] == ',') {
                reverse(chs, pre + 1, i - 1);
                pre = i;
            }
        }
        reverse(chs, pre + 1, chs.length - 1);

        StringBuffer sb = new StringBuffer();
        for (char c : chs) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void reverse(char[] chs, int l, int r) {
        while (l < r) {
            char tmp = chs[l];
            chs[l++] = chs[r];
            chs[r--] = tmp;
        }
    }

    public String ReverseSentence2(String str) {
        if(str == null) {
            return null;
        }
        if(str.trim().equals("")){
            return str;
        }
        //先翻转整个句子
        String reverStr = ReverseString(str);
        //在把每一个单词翻转
        String[] split = reverStr.split(" ");
        for(int i = 0; i < split.length; i++) {
            split[i] = ReverseString(split[i]);  //
        }
        String string = "";
        for(int i = 0; i < split.length;i++) {
            if(i == split.length - 1) {
                string = string + split[i];
            }else{
                string = string + split[i] + " ";
            }
        }
        return string;
    }
    public String ReverseString(String str) {
        String string = "";
        if(str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        int front = 0;
        int behind = str.length() - 1;
        while(front < behind) {
            swap(chars,front,behind);
            front++;
            behind--;
        }
        for(char c : chars) {
            string += c;
        }
        return string;
    }
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
