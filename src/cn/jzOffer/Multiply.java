package cn.jzOffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {

    public static void main(String[] args) {
        int[] arr = {5,4,1,2,3};
        int[] res = new Multiply().multiply(arr);
        for(int r : res) {
            System.out.print(r + " ");
        }
    }

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        //分成两半来求
        int[] left = new int[A.length];
        left[0] = 1;
        int[] mul = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] * A[i - 1];
        }
        int m = 1;  //保存后一半的乘积
        for (int i = A.length - 1; i >= 0; i--) {
            mul[i] = m * left[i];
            m *= A[i];
        }

        return mul;
    }
}

