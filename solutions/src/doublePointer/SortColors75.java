package doublePointer;

import java.util.Map;
import java.util.TreeMap;

/**
 * 对只包含0，1，2的数组进行排序
 * 双指针法很难想到
 *
 * */
public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,2,2,1,0,1,2};
        SortColors75 sortColors75 = new SortColors75();
        sortColors75.sortColors(nums);
    }
    public void sortColors(int[] nums) {
        // sortColors1(nums);
        // sortColors2(nums);
        sortColors3(nums);
    }

    // 哈希表计数(使用数组计数可以使用更小的内存)
    public void sortColors1(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i: nums) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }
        int index = 0;
        for (int i: map.keySet()) {
            int num = map.get(i);
            while (num > 0) {
                nums[index] = i;
                index++;
                num--;
            }
        }
    }

    // 使用冒泡排序
    public void sortColors2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    // 使用双指针
    public void sortColors3(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0 ; i <= r; i++) {
            // 遇到0则和l指针互换数值
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                l++;
            }
            // 遇到2则和r指针互换数值
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r] = tmp;
                r--;
                i--;
            }
        }
    }
}
