//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int dp [][];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         //date : 12th august 2024
         
         dp = new int[n+1][W+1];
         for(int i =0; i<dp.length; i++) Arrays.fill(dp[i], -1);
         return helper(wt, val, n, W);
    } 
    public static int helper(int [] wt, int [] val, int i, int w){
        if(w<0) return Integer.MIN_VALUE;
        if(w==0) return 0;
        if(i==0) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
        
        
        int notTake = helper(wt, val, i-1, w);
        
        int take = Integer.MIN_VALUE;
        
        take = helper(wt, val, i-1, w-wt[i-1]);
        if(take!=Integer.MIN_VALUE) take +=val[i-1];
        return dp[i][w] = Math.max(take, notTake);
    }
}


