package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 做法1: 回溯法，注意剪枝，比较耗时间
 * 做法2: 类比三数求和，先确定两根指针，另外两根指针从头部和尾部进行扫描，然后注意去重
 * */
public class FourSum18 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        // 回溯法
        return fourSum2(nums, target);
        // 指针法
        // return fourSum1(nums, target);
    }

    private List<List<Integer>> fourSum1(int[] nums, int target) {
        // 指针法
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // 重复
                    continue;
                }
                int sum1 = nums[i] + nums[j];
                if (nums[j] >= 0 && sum1 > target) {
                    break;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = sum1 + nums[k] + nums[l];
                    if (sum == target) {
                        // 找到
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        // 去重
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        k++;
                        l--;
                    }
                    else if (sum > target) {
                        l--;
                    }
                    else {
                        k++;
                    }
                }
            }
        }
        return result;
    }

    private List<List<Integer>> fourSum2(int[] nums, int target) {
        LinkedList<Integer> track = new LinkedList<>();
        trackback(0, track, nums, 0, target);
        return result;
    }

    private void trackback(int start, LinkedList<Integer> path, int[] nums, int sum, int target) {
        if (path.size() == 4) {
            if (sum == target) {
                // 找到
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                // 重复，剪枝
                continue;
            }
            if (nums[i] >= 0 && sum + nums[i] > target) {
                // 后面nums[i]都不可能，剪枝
                break;
            }
            path.push(nums[i]);
            sum += nums[i];
            trackback(i + 1, path, nums, sum, target);
            sum -= nums[i];
            path.pop();
        }
    }
}
