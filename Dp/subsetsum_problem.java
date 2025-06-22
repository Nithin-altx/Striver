class Solution {
    static Boolean[][] dp;

    static boolean solve(int i, int sum, int arr[]) {
        if (sum == 0) return true;         // found a valid subset
        if (i == arr.length) return false; // exhausted all elements

        if (dp[i][sum] != null) return dp[i][sum];

        boolean take = false;
        if (arr[i] <= sum) {
            take = solve(i + 1, sum - arr[i], arr);
        }
        boolean notTake = solve(i + 1, sum, arr);

        return dp[i][sum] = take || notTake;
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        dp = new Boolean[arr.length + 1][sum + 1];
        return solve(0, sum, arr);
    }
}
