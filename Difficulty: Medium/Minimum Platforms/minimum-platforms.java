//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) dep[i] = Integer.parseInt(str[i]);

            System.out.println(new Solution().findPlatform(arr, dep));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // date : 9 oct 2024
        // int n = arr.length;
        // int timings [][] = new int[n][2];
        // for(int i=0; i<n; i++){
        //     timings[i][0] = arr[i];
        //     timings[i][1] = dep[i];
        // }
        
        // Arrays.sort(timings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        // int max = 1, curr = 1,  prev_dep = timings[0][1];
        
        // for(int i=1; i<n; i++){
        //     if(timings[i][0] < prev_dep )
        //         curr++;
        //     else
        //         curr =1;
        //     prev_dep = timings[i][1];
        //     max = Math.max(curr, max);
        // }
        // return max;
        
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=1, j=0, res = 1, curr = 1;
        
       while(i<n && j<n){
           if(arr[i]<=dep[j]){
               curr ++;
               i++;
           }
           else{
               curr--;
               j++;
           }
           res = Math.max(res, curr);
       }
       return res;
    }
}
