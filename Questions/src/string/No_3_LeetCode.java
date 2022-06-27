package string;

import java.util.HashMap;
import java.util.HashSet;

public class No_3_LeetCode {


    //    自己写的
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int start = 0, end = 0;
        int max = 1;
        HashSet<Character> set = new HashSet<>();
        while (end <= s.length()) {
            String test = s.substring(start, end);
            set.clear();

            boolean hasDuplicated = false;
            for (int i = 0; i < test.toCharArray().length; i++) {

                char c = test.toCharArray()[i];
                if (set.contains(c)) {
                    hasDuplicated = true;
                    break;
                } else {
                    set.add(c);
                }
            }

            if (hasDuplicated) {
                start++;
                end++;
            } else {
                max = Math.max(end - start, max);
                end++;
            }
        }

        return max;
    }

    //    看了答案改进的
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int result = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char charAtIndex = s.charAt(end);
            if (map.containsKey(charAtIndex)) {
                // start是不存在重复字符的最大索引. 不能直接用map.get(charAtIndex) + 1， 否则abba这种，对于最后一个a，就会计算错误
                start = Math.max(start, map.get(charAtIndex) + 1);
            }
            result = Math.max(result, end - start + 1);
            map.put(charAtIndex, end);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abba"));
    }
}
