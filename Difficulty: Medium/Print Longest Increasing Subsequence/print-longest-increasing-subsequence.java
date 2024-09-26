//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        // date : 26 sept 2024
        
        int dp [] = new int[n];
        int hash [] = new int[n];
        hash[0] = 0;
        Arrays.fill(dp, 1);
        int lastIndex = 0, maxLis =1;
        
        for(int i=1; i<dp.length; i++){
            hash[i] = i; 
            for(int j=0; j<i; j++){
                if( arr[i] > arr[j] && dp[i]< dp[j] +1){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            
            if(maxLis < dp[i]){
                maxLis = dp[i];
                lastIndex = i;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[lastIndex]);
        
        while(hash[lastIndex] !=lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(arr[lastIndex]);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
