//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    long res =0;
    public long count(int coins[], int N, int sum) {
     var dp = new long [coins.length][sum+1];
     for(int i =0; i<sum+1; i++){
         if(i%coins[0]==0){
             dp[0][i] = 1;
         }
     }
     for(int i =1; i<dp.length; i++){
         for(int j =0; j<dp[0].length; j++){
             dp[i][j] = dp[i-1][j];
             if(coins[i]<=j){
                 dp[i][j]+=dp[i][j-coins[i]];
             }
         }
     }
     return dp[N-1][sum];
    }
}