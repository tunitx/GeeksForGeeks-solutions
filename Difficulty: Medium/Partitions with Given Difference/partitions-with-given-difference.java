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
    static int find(int[] arr,int n,int s1,int[][] dp){
        if(s1==0) return 1;
        if(n==-1||s1<0) return 0;
        if(dp[n][s1]!=-1) return dp[n][s1];
        if(arr[n]==0) return dp[n][s1]=find(arr,n-1,s1,dp);
        return dp[n][s1]=(find(arr,n-1,s1-arr[n],dp)+find(arr,n-1,s1,dp))%1000000007;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum=0,c=0;
        for(int a:arr){ sum+=a;  if(a==0) c++;  }
        if(sum<d) return 0;
        if((sum-d)%2==1) return 0;
        sum=(sum-d)/2;
        int[][] dp=new int[n][sum+1];
        for(int[] t: dp) Arrays.fill(t,-1);
        int ans=find(arr,n-1,sum,dp);
        while(c-->0)  ans=(ans<<1)%1000000007;
        return ans;
    }
}


        
