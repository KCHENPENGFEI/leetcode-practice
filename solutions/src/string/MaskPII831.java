package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/7/3 10:30 上午
 * 隐藏个人信息
 */
public class MaskPII831 {
    public String maskPII(String S) {
        if (S.contains("@")) {
            S = S.toLowerCase();
            String[] sep = S.split("@");
            String pre = sep[0];
            StringBuilder sb = new StringBuilder();
            sb.append(pre.charAt(0))
                    .append("*****")
                    .append(pre.charAt(pre.length() - 1))
                    .append('@')
                    .append(sep[1]);
            return sb.toString();
        }
        else {
            List<Character> numsList = new ArrayList<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                    numsList.add(S.charAt(i));
                }
            }
            if (numsList.size() == 10) {
                return trans(numsList);
            }
            else {
                List<Character> preList = numsList.subList(0, numsList.size() - 10);
                List<Character> lastList = numsList.subList(numsList.size() - 10, numsList.size());
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                for (int i = 0; i < preList.size(); i++) {
                    sb.append('*');
                }
                sb.append('-');
                sb.append(trans(lastList));
                return sb.toString();
            }
        }
    }

    public String trans(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i < 6) {
                sb.append('*');
                if (i == 2 || i == 5) {
                    sb.append('-');
                }
            }
            else {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
