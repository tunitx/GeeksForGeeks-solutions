//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int arr[], int k) {
        // code here
        
        double low = 0, high = 0, ans = 0;
        
        for(int i =1; i<arr.length; i++){
            high = arr[i] - arr[0];
        }
        
        double diff = 1e-6 ;
        while(high - low > diff){
            double mid = (low + high)/2.0;
            
            if(check(arr, mid, k)){
                ans = high;
                high = mid;
            }
            else low = mid;
        }
          return high;
    }
    
    public static  boolean check(int [] nums, double maxDiff, int k){
        int count = 0;
        
        for(int i =1 ; i<nums.length; i++){
            int diff = nums[i] - nums[i-1];
            count += (int) Math.ceil((double)diff/maxDiff) - 1;
        }
        return count <= k;
    }
}
