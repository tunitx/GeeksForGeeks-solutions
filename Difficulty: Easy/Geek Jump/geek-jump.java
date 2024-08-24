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
        dp = new int[N];
        Arrays.fill(dp, -1);
        return helper(N-1, arr);
    }
    public int helper(int curr , int [] arr){
        if(curr==0) return 0;
        if(dp[curr]!=-1) return dp[curr];
        
        
        int res1 = Math.abs(arr[curr]-arr[curr-1]) + helper(curr-1, arr);
        int res2 = Integer.MAX_VALUE;
        if(curr>1){
            res2 = Math.abs(arr[curr]-arr[curr-2]) + helper(curr-2,  arr);
        }
        return dp[curr] = Math.min(res1, res2);
    }
}
