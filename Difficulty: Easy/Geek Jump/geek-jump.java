//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int dp [];
    public int minimumEnergy(int arr[],int N){
        //code here
        // date : 14 sept 2024
        // dp = new int[N];
        // Arrays.fill(dp, -1);
        // return helper(0, arr, N);
        
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i =0; i<N-1; i++){
            dp[i+1] = Math.min(dp[i+1], dp[i] + Math.abs(arr[i+1] - arr[i]));
            if(i+2<N) 
                dp[i+2] = Math.min(dp[i+2], dp[i] + Math.abs(arr[i+2] - arr[i]));
        }
        return dp[N-1];
    }
    
    public int helper(int i, int [] arr, int N){
        if(i>=N-1) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int res1 = Math.abs(arr[i] - arr[i+1]) + helper(i+1, arr, N);
        int res2 = Integer.MAX_VALUE;
        if(i+2<N) res2 = Math.abs(arr[i] - arr[i+2]) + helper(i+2, arr, N);
        
        return dp[i] = Math.min(res1, res2);
    }
}