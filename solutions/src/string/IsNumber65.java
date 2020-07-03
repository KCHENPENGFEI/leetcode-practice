package string;

/**
 * @author chenpengfei
 * @date 2020/7/3 10:33 上午
 * 验证给定的字符串是否可以解释为十进制数字。
 */
public class IsNumber65 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.contains(".")) {
            // 如果以"(-/+)."开头
            if (s.matches("(-||\\+)?\\.\\d+e(-||\\+)?\\d+") || s.matches("(-||\\+)?\\.\\d+")) {
                return true;
            }
            // 如果以"(-/+)[1-9]"开头
            if (s.matches("(-||\\+)?\\d+\\.\\d+") ||
                    s.matches("(-||\\+)?\\d+\\.e(-||\\+)?\\d+") ||
                    s.matches("(-||\\+)?\\d+\\.\\d+e(-||\\+)?\\d+")) {
                return true;
            }
            // 如果以"."结尾
            if (s.matches("(-||\\+)?\\d+\\.")) {
                return true;
            }
            return false;
        }
        else if (s.contains("e")) {
            if (s.matches("(-||\\+)?\\d+e(-||\\+)?\\d+")) {
                return true;
            }
            return false;
        }
        else {
            return s.matches("(-||\\+)?\\d+");
        }
    }
}
