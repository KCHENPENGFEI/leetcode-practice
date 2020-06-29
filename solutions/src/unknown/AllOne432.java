package unknown;

import java.util.*;

/**
 * @author chenpengfei
 * @date 2020/6/29 11:23 下午
 *
 * 请你实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 * 做法: 两个Map，其中一个存储key -> value的关系，另外一个使用TreeMap存储value -> key[]的关系。
 * 需要注意的是，当TreeMap中value对应的key[]为空的时候，需要把这个value删除，不然会造成返回的结果为空
 */
public class AllOne432 {
    private Map<String, Integer> map;
    private Map<Integer, Set<String>> helperMap;

    /** Initialize your data structure here. */
    public AllOne432() {
        this.map = new HashMap<>();
        this.helperMap = new TreeMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if ("".equals(key)) {
            return;
        }
        int value = this.map.getOrDefault(key, 0);
        this.map.put(key, value + 1);
        Set<String> setValue = this.helperMap.getOrDefault(value + 1, new HashSet<>());
        setValue.add(key);
        this.helperMap.put(value + 1, setValue);
        if (value == 0) {
            return;
        }
        Set<String> newSetValue = this.helperMap.get(value);
        newSetValue.remove(key);
        if (newSetValue.size() == 0) {
            this.helperMap.remove(value);
        }
        else {
            this.helperMap.put(value, newSetValue);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if ("".equals(key)) {
            return;
        }
        if (!this.map.containsKey(key)) {
            return;
        }
        int value = this.map.get(key);
        if (!this.helperMap.containsKey(value)) {
            return;
        }
        Set<String> setValue = this.helperMap.get(value);
        Set<String> newSetValue = this.helperMap.getOrDefault(value - 1, new HashSet<>());

        if (value > 1) {
            this.map.put(key, value - 1);
            setValue.remove(key);
            if (setValue.size() == 0) {
                this.helperMap.remove(value);
            }
            else {
                this.helperMap.put(value, setValue);
            }
            newSetValue.add(key);
            this.helperMap.put(value - 1, newSetValue);
        }
        else {
            this.map.remove(key);
            setValue.remove(key);
            if (setValue.size() == 0) {
                this.helperMap.remove(value);
            }
            else {
                this.helperMap.put(value, setValue);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        String res = "";
        Set<String> set;
        int max = 0;
        if (this.map.size() == 0) {
            return res;
        }
        for (Integer integer : this.helperMap.keySet()) {
            max = integer;
        }
        if (max == 0) {
            return res;
        }
        set = this.helperMap.get(max);
        for (String s: set) {
            res = s;
            break;
        }
        return res;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        String res = "";
        int min = 0;
        Set<String> set = new HashSet<>();
        if (this.map.size() == 0) {
            return res;
        }
        Iterator<Integer> it = this.helperMap.keySet().iterator();
        if (it.hasNext()) {
            min = it.next();
        }
        if (min == 0) {
            return res;
        }
        set = this.helperMap.get(min);
        for (String s: set) {
            res = s;
            break;
        }
        return res;
    }
}
