package trackback;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations17 {
    List<String> result = new LinkedList<>();
    String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    // int pointer = 0;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        StringBuilder track = new StringBuilder();
        trackback(track, 0, digits, digits.length());
        return result;
    }

    /* 严格遵循回溯框架 */
    // track是路径、start是在digits中的位置，每一次循环中start++用于定位下一个数字，digits是输入数字串，n是digits长度
    private void trackback(StringBuilder track, int start, String digits, int n) {
        if (track.length() == n) {
            // 出口
            result.add(track.toString());
            return;
        }
        int number = digits.charAt(start) - '0';
        String choose = letterMap[number];
        for (int i = 0; i < choose.length(); i++) {
            // 加入路径
            track.append(choose.charAt(i));
            // 定位下一个数字
            start++;
            trackback(track, start, digits, n);
            // 撤销选择
            start--;
            track.deleteCharAt(track.length() - 1);
        }
    }
}
