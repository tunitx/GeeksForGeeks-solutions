//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    int dp [];
    public int minimizeCost(int arr[], int k) {
        // code here
        // date : 14 sept 2024
        int n = arr.length;
        dp = new int [arr.length];
        Arrays.fill(dp, -1);
        return helper(0, k, arr, n);
    }
    
    public int helper(int i, int k, int [] arr, int n){
        if(i== n-1) return 0;
        if(dp[i]!=-1) return dp[i];
        
        int res = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(i+j<n){
                res = Math.min(res, Math.abs(arr[i] - arr[i+j]) + helper(i+j, k, arr, n));
            }
        }
        return dp[i] = res;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, k);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends