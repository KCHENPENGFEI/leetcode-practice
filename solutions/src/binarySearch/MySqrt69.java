package binarySearch;

/**
 * 给了两种方式，一种二分求的是平方刚好大于目标值的数字a，然后返回a-1
 * 第二种方式求的是平方刚好小于等于目标值的数字b，然后直接返回b即可
 * */
public class MySqrt69 {
    public static void main(String[] args) {
        MySqrt69 mySqrt69 = new MySqrt69();
        int x = 2147395599;
        System.out.println(mySqrt69.mySqrt(x));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int l = 1;
        int r = x / 2 + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long ji = (long) mid * mid;
            if (ji > x) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    // 要注意一个点: 如果想使用r = mid - 1这样的写法，一定要保证mid向上取整，
    // 这样mid - 1之后才会和l相等，不然出不了循环
    // 用l = mid + 1的写法要向下取整
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1;
        int r = x / 2 + 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            long ji = (long) mid * mid;
            if (ji > x) {
                r = mid - 1;
            }
            else {
                l = mid;
            }
        }
        return l;
    }
}
