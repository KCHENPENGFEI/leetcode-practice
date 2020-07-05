package string;

/**
 * @author chenpengfei
 * @date 2020/7/5 11:06 上午
 */
public class GetHint299 {
    public String getHint(String secret, String guess) {
        int[] l1 = new int[10];
        int[] l2 = new int[10];
        int bulls = 0;
        int cows = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            else {
                // 统计每个数字在原始字符串和猜测字符串中出现的个数
                l1[secret.charAt(i) - '0']++;
                l2[guess.charAt(i) - '0']++;
            }
        }
        for (int j = 0; j < 10; j++) {
            // 选择两者最小值加到cow上
            cows += Math.min(l1[j], l2[j]);
        }
        sb.append(bulls)
                .append('A')
                .append(cows)
                .append('B');
        return sb.toString();
    }
}
