//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // Create a memoization table to store results of subproblems
        Boolean[][] dp = new Boolean[N+1][sum+1];
        
        // Initialize the memoization table with null
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = null;
            }
        }

        return isSubsetSumUtil(N, arr, sum, dp);
    }

    static Boolean isSubsetSumUtil(int i, int arr[], int sum, Boolean[][] dp) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (i == 0 && sum != 0) {
            return false;
        }

        // Check if the subproblem has already been solved
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        // If the current element is greater than the sum, it cannot be included
        if (arr[i-1] > sum) {
            dp[i][sum] = isSubsetSumUtil(i-1, arr, sum, dp);
        } else {
            // Otherwise, check both including and excluding the current element
            dp[i][sum] = isSubsetSumUtil(i-1, arr, sum, dp) || isSubsetSumUtil(i-1, arr, sum - arr[i-1], dp);
        }

        return dp[i][sum];
    }
}
