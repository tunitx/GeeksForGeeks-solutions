//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        // date : 30 aug 2024
        if(arr.get(0)<arr.get(arr.size()-1)) return 0;
        int low =0, high = arr.size()-1;
        
        //check for 0 rotated array or size rotated array
        // if(arr.get(low)< arr.get(high)) return 0;
        
        while(low<high){
            int mid = low +(high-low)/2;
            
            if(mid < arr.size()-1 && arr.get(mid)>arr.get(mid+1)) return mid +1;
            else if (arr.get(low)>=arr.get(mid)) high = mid;
            else low = mid +1;
        }
        return low +1;
    }
}