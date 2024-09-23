//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    HashMap<String, Boolean> dpMap;
    Set<String> ans ;
    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        int [][] dp = new int [s.length()+1][t.length()+1];
        
        for(int i =1; i<dp.length; i++){
            for(int j =1; j<dp[0].length; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        
         ans = new HashSet<>();
        
         dpMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        helper(s.length(), t.length(), sb, s, t, dp);
         List<String> list = new ArrayList<>(ans);
        Collections.sort(list);
        return list;
        
    }
    public void helper(int i, int j, StringBuilder str, String s1, String s2, int [][] dp ){
        if(i==0 || j==0) {
            ans.add(str.reverse().toString());
            str.reverse();
            return;
        }
        
        
       String key = i + "," + j + "," + str.toString();
        if(dpMap.containsKey(key)) return;
        
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            str = str.append(s1.charAt(i-1));
             key = i + "," + j + "," + str.toString();
            dpMap.put(key, true);
            helper(i-1, j-1, str, s1, s2, dp);
            str.deleteCharAt(str.length()-1);
            return;
        }
        else {
             key = i + "," + j + "," + str.toString();
            dpMap.put(key, true);
            if(dp[i-1][j] == dp[i][j] && dp[i][j-1] == dp[i][j]){
                helper(i-1, j, str, s1, s2, dp);
                helper(i, j-1, str, s1, s2, dp);
                return;
            }
            else {
                if(dp[i-1][j]>dp[i][j-1]) {
                    helper(i-1, j, str, s1, s2, dp);
                    return;
                }
                else {
                    helper(i, j-1, str, s1, s2, dp);
                    return;
                }
            }
        }
    }
}