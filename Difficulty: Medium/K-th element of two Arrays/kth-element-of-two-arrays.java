//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // Ensure that arr1 is the smaller array
        int n1 = arr1.length, n2 = arr2.length;
        
        if(n1 > n2) return kthElement(k, arr2, arr1); // Always binary search on smaller array
        
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;
            
            // Edge cases for boundaries
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : arr2[mid2];
            
            // If we have found the right partition
            if (l1 <= r2 && l2 <= r1) {
                return (long)Math.max(l1, l2);
            } 
            // If l1 is greater than r2, move search space to the left
            else if (l1 > r2) {
                high = mid1 - 1;
            } 
            // Otherwise, move search space to the right
            else {
                low = mid1 + 1;
            }
        }
        
        return 0; // This should never be reached if k is valid
    }
}
