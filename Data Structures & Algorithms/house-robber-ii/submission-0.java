class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Edge Cases
        if (n == 1)
            return nums[0];

        // Case 1 : Consider houses 0 to n-2
        int case1 = helper(nums, 0, n - 2);

        // Case 2 : Consider houses 1 to n-1
        int case2 = helper(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int helper(int[] nums, int start, int end) {

        int length = end - start + 1;

        int[] dp = new int[length];

        // Base Cases
        dp[0] = nums[start];

        if (length == 1)
            return dp[0];

        dp[1] = Math.max(nums[start], nums[start + 1]);

        // Fill DP
        for (int i = 2; i < length; i++) {

            int loot = nums[start + i] + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(loot, skip);
        }

        return dp[length - 1];
    }
}