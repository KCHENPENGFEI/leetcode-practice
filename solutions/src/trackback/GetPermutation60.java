package trackback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 原始的回溯算法，找到第k个直接break返回
 * 使用List的效率比使用StringBuilder高
 * */
public class GetPermutation60 {
    static int cnt = 0;
    static String result = "";
    List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        GetPermutation60 getPermutation = new GetPermutation60();
        getPermutation.getPermutation(3,3);
        System.out.println(result);
    }

    public String getPermutation(int n, int k) {
//        StringBuilder track = new StringBuilder();
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 1; i <= n; i++) {
//            sb.append(i);
//        }
//        List<Character> choose = sb.toString().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//        trackback(track, choose, k, n);
//        return result;
        List<Integer> choose = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            choose.add(i);
        }
        List<Integer> track = new ArrayList<>();
        trackback1(track, choose, k, n);
        StringBuilder sb = new StringBuilder();
        System.out.println(resultList.toString());
        for (int i: resultList) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void trackback(StringBuilder track, List<Character> choose, int k, int n) {
        if (track.length() == n) {
            // 出口
            cnt++;
            if (cnt == k) {
                result = track.toString();
            }
            return;
        }
        for (int i = 0; i < choose.size(); i++) {
            if (cnt == k) {
                break;
            }
            char c = choose.get(i);
            track.append(c);
            choose.remove(i);
            trackback(track, choose, k, n);
            track.deleteCharAt(track.length() - 1);
            choose.add(i, c);
        }
    }
    public void trackback1(List<Integer> track, List<Integer> choose, int k, int n) {
        if (track.size() == n) {
            cnt++;
            if (cnt == k) {
                resultList = new ArrayList<>(track);
            }
            return;
        }
        for (int i = 0; i < choose.size(); i++) {
            if (cnt == k) {
                break;
            }
            int num = choose.get(i);
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            trackback1(track, choose, k, n);
            track.remove(Integer.valueOf(num));
        }
    }
}
