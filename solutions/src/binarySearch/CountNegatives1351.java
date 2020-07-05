package binarySearch;

/**
 * @author chenpengfei
 * @date 2020/7/5 3:44 下午
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回 grid 中 负数 的数目。
 * 做法: 使用二分查找
 * 第一行使用二分查找找到第一个<=0的数字位置为c0,时间复杂度为O(log(col)), 由于纵向也是非递增的,
 * 所以第二行第一个<=0的数字位置肯定在[0, c0]之间，可以减小搜索范围，继续二分，时间复杂度为o(log(c0))
 */
public class CountNegatives1351 {
}
