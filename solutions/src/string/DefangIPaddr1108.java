package string;

/**
 * @author chenpengfei
 * @date 2020/7/8 9:13 下午
 */
public class DefangIPaddr1108 {
    public String defangIPaddr(String address) {
        String replace = "[.]";
        String[] sep = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sep.length; i++) {
            sb.append(sep[i]);
            if (i != 3) {
                sb.append(replace);
            }
        }
        return sb.toString();
    }
}
