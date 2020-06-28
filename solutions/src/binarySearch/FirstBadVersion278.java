package binarySearch;

/**
 * 第一个错误版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * */
public class FirstBadVersion278 {
    public static void main(String[] args) {
        int n = 10;
        FirstBadVersion278 firstBadVersion278 = new FirstBadVersion278();
        System.out.println(firstBadVersion278.firstBadVersion(n));
    }
    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (!isBadVersion(mid)) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (l == n + 1) {
            return 0;
        }
        else {
            return l;
        }
    }

    boolean isBadVersion(int n) {
        return true;
    }
}
