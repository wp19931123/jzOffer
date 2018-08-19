package cn.jzOffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该
 * 压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 1, 2};
        System.out.print(new IsPopOrder().IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        Stack<Integer> st = new Stack<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < len && index2 < len) {
            if (st.isEmpty()) {
                st.push(pushA[index1++]);
            }
            if (st.peek() == popA[index2]) {
                st.pop();
                index2++;
            } else {
                if (index1 < len) {
                    st.push(pushA[index1++]);
                }
            }
        }
        if (index1 == len) {
            while (!st.isEmpty()) {
                if (st.pop() != popA[index2++]) {
                    return false;
                }
            }
        }
        if (index2 == len) {
            return true;
        } else {
            return false;
        }

    }

    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        st.push(pushA[0]);
        while (j <= popA.length - 1) {
            while (popA[j] != st.peek()) {
                if (i == pushA.length) return false;
                st.push(pushA[i++]);
            }
            j++;
            st.pop();
        }
        return true;
    }
}
