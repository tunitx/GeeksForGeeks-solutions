//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean arr1[] = new boolean[n];
            boolean arr2[] = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1") ? true : false;
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1") ? true : false;
            }

            int ans = new Solution().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
        // code here
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum1 =0;
        int sum2 =0;
        int ans =0;
        
        map.put(0,-1);
        
        for(int i =0; i<n; i++){
           sum1 += arr1[i] ? 1 : 0;
            sum2 += arr2[i] ? 1 : 0;
            
            int diff = sum1 - sum2;
            
            if(map.containsKey(diff)) ans = Math.max(ans, i-map.get(diff));
            else map.put(diff, i);
            
        }
        return ans;
    }
}