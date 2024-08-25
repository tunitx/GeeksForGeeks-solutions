//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
   static int dp[][];
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        // date : 25th august 2024
        dp = new int [wt.length][W+1];
        for(int i =0; i<dp.length; i++) Arrays.fill(dp[i],-1);
        return helper(0,0,wt, val, W);
    }
    public static int helper(int idx, int currW, int [] wt, int val [], int W){
         if(currW>W) return Integer.MIN_VALUE;
        if(currW==W) return 0;
        if(idx==val.length) return 0;
       
        if(dp[idx][currW]!=-1) return dp[idx][currW];
        
        //exclude the current w
        int res1 = helper(idx+1, currW, wt, val,W);
        
        //include the current w
        
        int res2 = Integer.MIN_VALUE;
        res2 =  helper(idx+1, currW+wt[idx], wt, val,W);
        if(res2!=Integer.MIN_VALUE) res2+=val[idx];
        
        return dp[idx][currW] = Math.max(res1, res2);
    }
}
