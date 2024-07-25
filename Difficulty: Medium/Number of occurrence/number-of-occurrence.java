//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        
        //date : 25th july 2024
        
        int firstOcc = BinarySearch(arr, 0, n-1, x, true);
        int lastOcc = BinarySearch(arr, 0, n-1, x, false);
        if(firstOcc == -1 && lastOcc ==-1) return 0;
        
        return lastOcc-firstOcc+1;
    }
    
    public int BinarySearch(int [] arr, int start , int end, int target, Boolean isStart){
        int res = -1;
        
        while(start<=end){
            int mid = (start+end)/2;
            
            if(arr[mid]<target){
                start = mid +1;
            }
            else if (arr[mid]>target){
                end = mid-1;
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