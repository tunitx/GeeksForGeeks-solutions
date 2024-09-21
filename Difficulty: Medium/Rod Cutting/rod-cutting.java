//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    int dp [][];
    public int cutRod(int price[], int n) {
        // date : 22 sept 2024
        
        dp  = new int[price.length][n+1];
        
        for(int row [] : dp) Arrays.fill(row, -1);
        
        return helper(0, n, price);
    }
    
    public int helper(int i, int n, int [] price){
        if(n==0) return 0;
        if(i == price.length) return Integer.MIN_VALUE;
        if(dp[i][n]!=-1) return dp[i][n];        

        int res1 = Integer.MIN_VALUE;
        if(n>=(i+1)){
            int temp = helper(i, n-(i+1), price);
            if(temp!=Integer.MIN_VALUE)
                res1 = temp + price[i];
        }
        int res2 = helper(i+1, n, price);
        
        return dp[i][n] = Math.max(res1, res2);
            
    }
}