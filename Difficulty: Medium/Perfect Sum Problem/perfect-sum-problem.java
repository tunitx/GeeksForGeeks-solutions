//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    static int find(int[] arr,int n,int sum,int[][] dp){
        if(sum==0) return 1;
        if(n==-1||sum<0) return 0;
        if(dp[n][sum]!=-1)  return dp[n][sum]; 
        if(arr[n]==0) return dp[n][sum]=find(arr,n-1,sum,dp);
        return dp[n][sum]=(find(arr,n-1,sum-arr[n],dp)+find(arr,n-1,sum,dp))%1000000007;
    }
    public int perfectSum(int arr[],int n, int sum) 
    { 
        // Your code goes here
        int[][] dp=new int[n][sum+1];
        for(int[] t:dp) Arrays.fill(t,-1);
        int c=0;
        for(int a:arr) if(a==0) c++;
        int k=find(arr,n-1,sum,dp);
        return k*(1<<c);
    } 
}