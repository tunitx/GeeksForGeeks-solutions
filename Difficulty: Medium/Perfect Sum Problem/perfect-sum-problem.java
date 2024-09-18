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

    int dp [][];
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new int [n][sum+1];
	    for(int row [] : dp) Arrays.fill(row, -1);
	    
	    int k = helper(0, sum, arr, n);
	    int count =0;
	    for(int i : arr) if(i==0) count ++;
	    return k*(1<<count);
	} 
	public int helper(int i, int sum, int arr [], int n){
	    if(sum == 0) return 1;
	    if(i == n || sum<0 ) return 0;
	    if(dp[i][sum]!=-1) return dp[i][sum];
	    
	    if(arr[i] == 0) return helper(i+1, sum, arr, n);
	    int res1 = helper(i+1, sum, arr, n);
	    int res2 = helper(i+1, sum - arr[i], arr, n);
	    
	    return dp[i][sum]  = (res1 + res2)%1000000007 ;
	}
} 