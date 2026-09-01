import java.util.ArrayList;

class Solution {
    void merge(int[] arr, int low, int mid, int high, int[] ct){
        ArrayList<Integer> temp = new ArrayList<>();
        int l = low;
        int r = mid+1;
        while (l<=mid && r<=high){
            if (arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }else {
                temp.add(arr[r]);
                ct[0] = ct[0] + mid-l+1;
                r++;
            }
        }
        while (l<=mid){
            temp.add(arr[l]);
            l++;
        }
        while (r<=high){
            temp.add(arr[r]);
            r++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    void mergeSort(int[] arr, int low, int high, int[] ct){
        if(low<high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, ct);
            mergeSort(arr, mid + 1, high, ct);
            merge(arr, low, mid, high, ct);
        }
    }
    public int inversionCount(int arr[]) {
        int[] ct = new int[1];
        mergeSort(arr, 0, arr.length-1, ct);
        return ct[0];

    }
}