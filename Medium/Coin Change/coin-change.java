//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        //2nd submission 
        //date: 1 march 2023
        long [][] mat = new long [coins.length][sum+1];
        for(int i =0; i<=sum; i++){
            if(i%coins[0]==0){
                mat[0][i] =1;
            }
            else{
                mat[0][i] = 0;
            }
        }
        for(int i =1; i<coins.length; i++){
            mat[i][0] =1;
            for(int j =0; j<=sum; j++){
                if(coins[i]>j){
                    mat[i][j] = mat[i-1][j];
                }
                else{
                    mat[i][j] = mat[i][j-coins[i]] +mat[i-1][j];
                }
            }
        }
        return mat[coins.length-1][sum];
        
    }
}