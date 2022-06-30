package dp;

// 最大子序和
public class No_53_LeetCode {

    // 贪心法。
    static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int lastSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curSum = nums[i];
            if (lastSum > 0) {
                curSum += lastSum;
            }

            lastSum = curSum;

            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }



    public static void main(String[] args) {
        System.out.println(new No_53_LeetCode().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new No_53_LeetCode().maxSubArray(new int[]{1}));
        System.out.println(new No_53_LeetCode().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
