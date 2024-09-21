//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp [][];
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // date : 22 sept 2024
        
        dp = new int [N][W+1];
        for(int row [] : dp) Arrays.fill(row, -1);
        
        return helper(0, W, val, wt);
    }
    
    public static int helper(int i, int w, int [] val, int [] wt){
        if(w ==0 || i == wt.length) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
        
        int res1 =0;
        if(w>=wt[i])
            res1 = val[i] + helper(i, w-wt[i], val, wt);
        
        int res2 = helper(i+1, w, val, wt);
        
        return dp[i][w] = Math.max(res1, res2);
    }
}