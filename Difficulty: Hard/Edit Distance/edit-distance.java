class Solution {
    
        int recc(String s, String t, int i, int j, Integer[][] dp){
            if (i<0){
                return j+1;
            }
            if (j<0){
                return i+1;
            }
            if (dp[i][j]!=null){
                return dp[i][j];
            }
            if (s.charAt(i)==t.charAt(j)){
                return recc(s, t, i-1, j-1, dp);
            }
            int delete = recc(s, t, i-1, j, dp);
            int insert = recc(s, t, i, j-1, dp);
            int replace = recc(s, t, i-1, j-1, dp);
            return dp[i][j] = 1+Math.min(delete, Math.min(insert, replace));
        }
        public int minDistance(String word1, String word2) {
            Integer[][] dp = new Integer[word1.length()][word2.length()];
            return recc(word1, word2, word1.length()-1, word2.length()-1, dp);
        }
    

    public int editDistance(String s1, String s2) {
        return minDistance(s1, s2);
        
    }
}