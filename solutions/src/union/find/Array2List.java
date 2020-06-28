package union.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenpengfei
 * @date 2020/6/25 2:14 下午
 */
public class Array2List {
    public static List<List<String>> transform(String[][] arrays) {
        List<List<String>> lists = new ArrayList<>();
        for (String[] arr: arrays) {
            List<String> tmp = new ArrayList<>(Arrays.asList(arr));
            lists.add(tmp);
        }
        return lists;
    }
}
