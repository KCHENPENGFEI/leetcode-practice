package binarySearch;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 做法: 利用x^n = (x^2)^(n/2)不断将x = x^2，如果n是奇数，那么x^n = x(x^2)^(n//2)
 * */
public class MyPow50 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 11;
        MyPow50 myPow50 = new MyPow50();
        System.out.println(myPow50.myPow(x, n));
    }
    public double myPow(double x, int n) {
        if (x == 0.0) {
            return 0.0;
        }
        double res = 1.0;
        long l = (long) n;
        if (l < 0) {
            x = 1 / x;
            l = - l;
        }
        while (l != 0) {
            if (l % 2 == 0) {
                // n是偶数
                x = x * x;
            }
            else {
                res = res * x;
                x = x * x;
            }
            l = l / 2;
        }
        return res;
    }
}
