class Solution {
    int f(int[] arr, int i, int target, Integer[][] dp){
        if (i<0){
            return 0;
        }
        if (target==0){
            return 0;
        }
        if (dp[i][target]!=null){
            return dp[i][target];
        }
        int notTake = f(arr, i-1, target, dp);
        int take = 0;
        if (target-(i+1)>=0){
            take = arr[i] + f(arr, i, target-(i+1), dp);
        }
        return dp[i][target] = Math.max(take, notTake);
    }
    public int cutRod(int[] price) {
        Integer[][] dp = new Integer[price.length][price.length+1];
        return f(price, price.length-1, price.length, dp);


    }
}