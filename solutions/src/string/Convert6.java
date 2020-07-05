package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/5 12:49 上午
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 做法: 遍历s可以发现s的字符所在行有以下变化规律: 1,2,3,...,numRows,numRows - 1,numRows - 2,...,1,2,3,..
 * 所以我们构造一个list用来模拟这种变化，定义flag定义方向
 */
public class Convert6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        if (s.length() == 0) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int flag = -1;
        int i = 0;
        int cnt = 0;
        while (cnt < s.length()) {
            // 获取目前是第几行
            StringBuilder sb = list.get(i);
            sb.append(s.charAt(cnt));
            // 遇到头部和尾部flag翻转
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            // 向前走一步或者向后走一步
            i += flag;
            cnt++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb: list) {
            res.append(sb);
        }
        return res.toString();
    }
}
