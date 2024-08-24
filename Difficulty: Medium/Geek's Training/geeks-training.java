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
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int dp [][];
    public int maximumPoints(int arr[][], int N) {
        // code here
        // date : 24 august 2024
        dp = new int [arr.length][4];
        // for(int [] num : dp) Arrays.fill(num, -1);
        // return helper(arr, N-1, 3);
        dp[0][0] = Math.max(arr[0][1], arr[0][2]); // Max points if no task was performed yesterday (index 0)
        dp[0][1] = Math.max(arr[0][0], arr[0][2]); // Max points if task 1 wasn't performed yesterday
        dp[0][2] = Math.max(arr[0][0], arr[0][1]); // Max points if task 2 wasn't performed yesterday
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); // Max points if no restriction on last day task
        
        for(int day =1; day<arr.length; day ++){
            for(int lastDay = 0; lastDay<4; lastDay++){
                dp[day][lastDay] = 0;
              for (int task = 0; task < 3; task++) {
                    if (task != lastDay) {
                        int temp = arr[day][task] + dp[day-1][task]; // Add current task points to best of previous day
                        dp[day][lastDay] = Math.max(dp[day][lastDay], temp);
                    }
                }
                    
                }
            }
             return dp[N-1][3];
        }
       

    
    public int helper(int [][] arr , int day, int prevDay){
        if(dp[day][prevDay]!=-1) return dp[day][prevDay];
        if(day ==0){
            int max = 0;
            for(int k =0; k<arr[0].length; k++){
                if(k!=prevDay) max = Math.max(max, arr[day][k]);
            }
            return dp[day][prevDay] = max;
        }
        
        
        int res =0;
        for(int col =0; col<arr[0].length; col++){
            if(col!=prevDay){
                res = Math.max(res, arr[day][col] + helper(arr, day-1, col));
            }
        }
        return dp[day][prevDay] = res;
    }
}