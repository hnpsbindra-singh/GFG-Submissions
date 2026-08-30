import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int target, int k, int start) {
        if (target==0&&k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <=9; i++) {
            if (temp.contains(i)||k<=0||i>target){
                continue;
            }
            temp.add(i);
            backtrack(res, temp, target-i, k-1, i+1);
            temp.remove(temp.size()-1);
        }
    }
}