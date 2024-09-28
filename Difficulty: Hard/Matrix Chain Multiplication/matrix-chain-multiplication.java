//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp [][];
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        dp = new int[N][N];
        for(int row [] : dp) Arrays.fill(row, -1);
        
        return helper(1,N-1, arr);
    }
    
    public static int helper(int i, int j, int arr[]){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        int min_steps = Integer.MAX_VALUE;
        for(int k =i; k<j; k++){
            int steps = arr[i-1] * arr[k] * arr[j]
            + helper(i, k, arr)
            + helper(k+1, j, arr);
            
            min_steps = Math.min(min_steps, steps);
        }
        
        return dp[i][j] = min_steps;
    }
}