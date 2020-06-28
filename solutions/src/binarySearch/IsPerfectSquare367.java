package binarySearch;

/**
 * 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * */
public class IsPerfectSquare367 {
    public static void main(String[] args) {
        int num = 808201;
        IsPerfectSquare367 isPerfectSquare367 = new IsPerfectSquare367();
        System.out.println(isPerfectSquare367.isPerfectSquare(num));
    }
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num / 2 + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long ji = (long) mid * mid;
            if (ji < num) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l * l == num;
    }
}
