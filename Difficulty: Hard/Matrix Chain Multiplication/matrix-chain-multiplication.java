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
        //date : 15th augsut 2024
        
        //MCM dp
        dp = new int[arr.length][arr.length];
        for(int i =0; i<dp.length; i++) Arrays.fill(dp[i],-1);
        return helper(arr, 1, N-1);
    }
        

    static int helper(int [] nums, int i, int j){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
         int res = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int temp = Math.min(res, helper(nums, i,k) + helper(nums, k+1, j) + nums[i-1]*nums[k]*nums[j]);
            res = Math.min(res, temp);
        }
        return dp[i][j] =  res;
    }
}