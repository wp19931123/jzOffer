package cn.jzOffer;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {

    public static void main(String[] args) {
        System.out.print(new GetUglyNumber_Solution().GetUglyNumber_Solution(60) + "   ");
    }


    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        int m2 = 0;  //表示索引
        int m3 = 0;
        int m5 = 0;
        int[] uglys = new int[index];
        uglys[0] = 1;
        int i = 1;
        while (i < index) {
            uglys[i] = min(uglys[m2] * 2, uglys[m3] * 3, uglys[m5] * 5);
            while (uglys[m2] * 2 <= uglys[i]) {
                m2++;
            }
            while (uglys[m3] * 3 <= uglys[i]) {
                m3++;
            }
            while (uglys[m5] * 5 <= uglys[i]) {
                m5++;
            }
            i++;
        }
        return uglys[index - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
