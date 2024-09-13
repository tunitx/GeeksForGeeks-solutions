//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        
        int ansRow = -1, prevMax = -1;
        
        for(int i =0; i<arr.length; i++){
            int currMax = firstOcc(arr, i);
            
           if(currMax !=-1){
              int max = arr[i].length - currMax;
               
               if(max>prevMax){
                   ansRow = i;
                   prevMax = max;
               }
           }
        }
        
        return ansRow;
        
    }
    
    public int firstOcc(int [][] arr, int row){
        int ans = -1;
        
        int low =0, high = arr[row].length-1;
        
        while(low<=high){
            int mid = low +(high-low)/2;
            
            if(arr[row][mid] == 1){
                ans = mid;
                high = mid -1;
            }
            else low = mid +1;
        }
        
        return ans;
    }
}