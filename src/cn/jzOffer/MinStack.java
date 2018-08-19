package cn.jzOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 */
public class MinStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
        if (s2.isEmpty()) {
            s2.push(node);
        } else if (s2.peek() > node) {
            s2.push(node);
        } else {
            s2.push(s2.peek());
        }
    }

    public void pop() {
        if (s2.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        s1.pop();
        s2.pop();
    }

    public int top() {
        if (s2.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return s1.peek();
    }

    public int min() {
        if (s2.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return s2.peek();
    }
}
