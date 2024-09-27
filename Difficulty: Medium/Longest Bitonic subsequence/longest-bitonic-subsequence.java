//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] nums = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.LongestBitonicSequence(n, nums);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        // date : 27 sept 2024
        int dp1 [] = new int[n];
        int dp2 [] = new int[n];
        
        // calculating increasing LS;
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        int max1 = 1;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
            }
            max1 = Math.max(max1, dp1[i]);
        }
        
        for(int i = n-2; i>=0; i--){
            for(int j = n-1; j>i; j--){
                if(nums[i] > nums[j]){
                    dp2[i] = Math.max(dp2[i], 1 + dp2[j]);
                }
            }
            max1 = Math.max(max1, dp2[i]);
        }
        int max =0;
        
        for(int i=0; i<n; i++){
            if(dp1[i]>1 && dp2[i]>1)
                 max = Math.max(max, dp1[i] + dp2[i] -1);
        }
        return max;
    }
}
