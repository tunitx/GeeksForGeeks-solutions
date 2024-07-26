//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.countZeroes(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int countZeroes(int[] arr) {
        // code here
        int firstOcc= BinarySearch(arr, 0, arr.length-1, 0, true);
        int lastOcc = BinarySearch(arr, 0, arr.length-1, 0, false);
        
        return lastOcc-firstOcc+1;
    }
    
    int BinarySearch(int [] arr, int start, int end, int target, Boolean isStart){
        int res = -1;
        
        while(start<=end){
            int mid = (start+end)/2;
            
            if(arr[mid]==1){
                start = mid+1;
            }
            else{
                res = mid;
                if(isStart) end = mid-1;
                else start = mid+1;
            }
        }
        return res;
    }
}
