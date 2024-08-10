//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{   
    int dp [];
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       //date : 10 aug 2024
       
       //Memoisation based solution
       dp = new int[n+1];
      Arrays.fill(dp,-1);
       int res = helper(n,x,y,z);
       if(res<0) return 0;
       return res;
    //   return res ?res!=Integer.MIN_VALUE:-1;
    }
    public int helper(int sum, int x, int y, int z){
        if(sum==0) return dp[sum]=0;
        if(sum<0) return Integer.MIN_VALUE;
        if(dp[sum]!=-1) return dp[sum];
        int res = Math.max(helper(sum-x,x,y,z), Math.max(helper(sum-y,x,y,z),
        
        helper(sum-z,x,y,z)));
        
       return dp[sum] = ++res;
        
    }
}
