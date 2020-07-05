package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenpengfei
 * @date 2020/7/5 12:15 上午
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 做法: 定义一个栈
 *
 */
public class SimplifyPath71 {
    public String simplifyPath(String path) {
        if (!path.startsWith("/")) {
            return "/";
        }
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/+");
        for (String s : paths) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(s) && !"".equals(s)) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
