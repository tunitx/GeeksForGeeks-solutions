//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod = 1000000007;
    static int dp [][];
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        // date : 20 sept 2024
        
        int totalSum = 0, zeros =0, target =0;
        
        for(int i : arr){
            totalSum +=i;
            if(i==0) zeros ++;
        } 
        
        if((totalSum+d)%2!=0) return 0;
        
        target = (totalSum +d)/2;
        
        dp = new int [n][target+1];
        
        for(int [] row : dp) Arrays.fill(row, -1);
        
        int k = helper(0, target, arr);
        
        while(zeros-->0) k = (k<<1)%mod;
        
        return k;
        
    }
    
    public static int helper(int i, int sum, int [] arr){
        if(sum ==0) return 1;
        if(i==arr.length) return 0;
        if(dp[i][sum]!=-1) return dp[i][sum];
        
        if(arr[i]==0) return helper(i+1, sum , arr);
        
        int res1 = helper(i+1, sum, arr);
        int res2 =0;
        if(sum>=arr[i])
            res2 = helper(i+1, sum - arr[i], arr);
        
        return dp[i][sum] = (res1 + res2)%mod;
    }
}
        
