class Solution {
    public int lowerBond(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int ans = arr.length;
        while (start<=end){
            int mid =(start+end)/2;
            if (arr[mid] == 1){
                ans = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return ans;
    }
    public int rowWithMax1s(int[][] arr) {
        int ans = 0;
        int row = -1;
        int n = arr[0].length;
        for (int i = 0; i < arr.length; i++){
            int lb = lowerBond(arr[i]);
            int res = n-lb;
            if(res>ans){
                row = i;
                ans = res;
            }
        }
        return row;
    }
}