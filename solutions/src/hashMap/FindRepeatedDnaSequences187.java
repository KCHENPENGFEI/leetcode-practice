package hashMap;

import java.util.*;

public class FindRepeatedDnaSequences187 {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAA";
        FindRepeatedDnaSequences187 findRepeatedDnaSequences187 = new FindRepeatedDnaSequences187();
        System.out.println(findRepeatedDnaSequences187.findRepeatedDnaSequences(s));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!set.contains(sub)) {
                set.add(sub);
            }
            else {
                if (!result.contains(sub)) {
                    result.add(sub);
                }
            }
        }
        return result;
    }
}
