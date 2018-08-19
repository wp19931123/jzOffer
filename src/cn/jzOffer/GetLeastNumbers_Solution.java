package cn.jzOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.print(new GetLeastNumbers_Solution().GetLeastNumbers_Solution(arr,4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length || k <= 0) {
            return res;
        }
        //堆
        Queue<Integer> q = new PriorityQueue<>((a,b) -> (b-a));
        for(int i = 0;i < input.length;i++) {
            if(q.size() < k) {
                q.offer(input[i]);
            }else{
                if(q.peek() > input[i]) {
                    q.poll();
                    q.offer(input[i]);
                }
            }
        }
        //弹出
        while(!q.isEmpty()) {
            res.add(q.poll());
        }

        Collections.reverse(res);
        return res;
    }
}
