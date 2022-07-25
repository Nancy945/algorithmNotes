package dp;


/**
 * 教程：
 * https://www.bilibili.com/video/BV1C7411K79w
 */
public class Bags {

    // w为重量，v为价值，s为数量。 dp[i][j] 为 在允许使用前i件物品的情况下，容量为j时，最大价值。

    /**
     * 物品编号
     * 0 1 2 3
     * 物品体积
     * 1 2 3 4
     * 物品价值
     * 2 3 4 5
     * 每个物品仅有一件，要求在给定背包容量M的情况下，计算最大价值
     */
    static class Bags_01 {
        /**
         * dp[i][j] = max(dp[i-1][j], dp[i-1]j[j-w[i] + v[i])
         * 简化后： dp[j] =  max(dp[j], dp[j-w[i]] + v[i])  （需要逆向构建dp）
         *
         */
        public void main(String[] args) {
            int[] w = new int[50];
            int[] v = new int[50];
            int[][] dp = new int[50][50];
            int[] dp1 = new int[50];

            int n = 4;// 4个物品
            int m = 10;// 允许的最大容量


            // 优化前
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j < w[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                    }
                }
            }

            // 优化后
            for (int i = 1; i <= n; i++) {
                // 这里遍历是逆向
                for (int j = m; j >= 1; j--) {
                    if (j >= w[i]) {
                        dp1[j] = Math.max(dp1[j], dp1[j - w[i]] + v[i]);
                    }
                }
            }

        }
    }

    /**
     * 物品编号
     * 0 1 2 3
     * 物品体积
     * 1 2 3 4
     * 物品价值
     * 2 3 4 5
     * 每个物品有无限键，要求在给定背包容量M的情况下，计算最大价值
     */
    static class Bags_Complete {

        /**
         * dp[i][j] = max(dp[i-1][j], dp[i]j[j-w[i]] + c[i])
         * 简化后： dp[j] =  max(dp[j], dp[j-w[i] + c[i])  （需要顺向构建dp）
         *
         */

        public void main(String[] args) {
            int[] w = new int[50];
            int[] v = new int[50];
            int[][] dp = new int[50][50];
            int[] dp1 = new int[50];

            int n = 4;// 4个物品
            int m = 10;// 允许的最大容量

            // 优化前
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (j < w[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i ][j - w[i]] + v[i]);
                    }
                }
            }


            // 优化第一次
            for (int i = 1; i <= n; i++) {
                // 这里遍历是顺向
                for (int j = 1; j <= m; j++) {
                    if (j >= w[i]) {
                        dp1[j] = Math.max(dp1[j], dp1[j - w[i]] + v[i]);
                    }
                }
            }

            // 优化第二次
            for (int i = 0; i <= n; i++) {
                for (int j = w[i]; j <= m; j++) {
                    dp1[j] = Math.max(dp1[j], dp1[j - w[i]] + v[i]);
                }
            }
        }
    }

    /**
     * 物品编号
     * 0 1 2 3
     * 物品体积
     * 1 2 3 4
     * 物品价值
     * 2 3 4 5
     * 第i个物品有s[i]个，要求在给定背包容量M的情况下，计算最大价值
     */
    static class BagsMulti {
        public void main(String[] args) {
            // 重量
            int[] w = new int[50];
            // 价值
            int[] v = new int[50];
            // 数量
            int[] s = new int[50];

            // step1:拆分物品
            // ， 比如一个东西有5件，那么放他变成5个物品（每个都是w1,v1）。
            // 更优的方法是转成2件（用二进制拆分），  第一件有1份（W1,V1），第二件有4份（4W1,4V1），

            // step2:此时已经是01背包问题了 直接用01背包解决

        }
    }
}
