package string;

public class No_28_LeetCode {
    /**
     * https://leetcode.cn/problems/implement-strstr/solution/yi-dong-de-rabin-karpsuan-fa-hao-xiang-mei-ren-xie/
     */
    class RabinKarp {
        public int strStr(String txt, String pat) {
            if (pat.length() == 0) {
                return 0;
            }
            if (txt.length() == 0) {
                return -1;
            }
            int m = pat.length();
            int MOD = 1000000;// 100w

            // 计算power，也就是幂，用于后面删除头用，所以要多计算一位
            int power = 1;
            for (int i = 0; i < m; i++) {
                power = power * 31 % MOD;
            }

            // 计算pat的hash值
            int patHash = 0;
            for (int i = 0; i < m; i++) {
                patHash = (patHash * 31 + pat.charAt(i)) % MOD;
            }

            // subHash
            int subStrHash = 0;
            int n = txt.length();
            for (int i = 0; i < n; i++) {
                subStrHash = (subStrHash * 31 + txt.charAt(i)) % MOD;
                // 如果不够pat的长度
                if (i + 1 < m) {
                    continue;
                }
                // 如果超过pat的长度,要去掉头
                if (i + 1 > m) {
                    subStrHash = subStrHash - (txt.charAt(i - m) * power) % MOD;
                    if (subStrHash < 0) {
                        subStrHash += MOD;
                    }
                }

                // double check
                if (subStrHash == patHash) {
                    if (txt.subSequence(i - m + 1, i + 1).equals(pat)) {
                        return i - m + 1;
                    }
                }
            }
            return -1;
        }
    }


}
