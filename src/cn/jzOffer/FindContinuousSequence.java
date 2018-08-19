package cn.jzOffer;

import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        System.out.print(new FindContinuousSequence().FindContinuousSequence(100));
    }

    //双指针法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        int front = 1;
        int back = 2;
        int curSum = 3;
        tmp.add(1);
        tmp.add(2);
        while(front < back && back < sum) {
            if(curSum == sum) {
                res.add(new ArrayList<>(tmp));
                back++;
                curSum += back;
                tmp.add(back);
            }else if(curSum < sum) {
                back++;
                tmp.add(back);
                curSum += back;
            }else{
                curSum -= front;
                tmp.remove((Integer)front);
                front++;
            }
        }

        return res;
    }
}
