class Solution {
    int f(int[] arr, int i, int prev, Integer[][] dp){
        if (i==arr.length){
            return 0;
        }
        if (dp[i][prev+1]!=null){
            return dp[i][prev+1];
        }
        int not = f(arr, i+1, prev, dp);
        int take = 0;
        if(prev==-1||arr[i]>arr[prev]){
            take = arr[i] + f(arr, i+1, i, dp);
        }
        return dp[i][prev+1] = Math.max(take, not);
    }
    public int maxSumIS(int[] arr) {
        Integer[][] dp = new Integer[arr.length][arr.length+1];
        return f(arr, 0, -1, dp);
    }
}