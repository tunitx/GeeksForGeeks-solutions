//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {
    int dp [][];
    public int minCoins(int coins[], int M, int sum) {
        // Your code goes here
        dp = new int[coins.length][sum+1];
        for(int row [] : dp) Arrays.fill(row, -1);
        int res = helper(0, sum, coins);
        return res >= 1e9 ? -1 : res;
    }
    public int helper(int i, int sum, int [] coins){
        if(sum ==0) return 0;
        if(i== coins.length) return (int)1e9;
        if(dp[i][sum]!=-1) return dp[i][sum];
        
        int res1 = helper(i+1, sum, coins);
        int res2 = (int)1e9;
        if(coins[i]<=sum){
            res2 = 1 + helper(i, sum-coins[i], coins); 
        }
        return dp[i][sum] = Math.min(res1, res2);
            
    }
}