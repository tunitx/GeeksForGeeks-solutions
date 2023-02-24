//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        //Date : 24 feb 2023
        //so this solution works on the idea of storing maximum elements starting 
        //from last index till first index in an auxilary array max[j];
        int [] max = new int[n];
        int maxE= Integer.MIN_VALUE;
        for(int i =n-1; i>=0; i--){
            maxE = Math.max(maxE, arr[i]);
            max[i] = maxE;
        }
        //then we check for the condition max[j]>=arr[i], if true, then we just calclulate 
        //the max length, if not true, we gon check backwards in max[j] array by doing j-- only.
        int i =0, j =arr.length-1;
        int maxLen = 0;
        while(i<arr.length){
            if(max[j]>=arr[i]){
                maxLen = Math.max(maxLen, j-i);
                j=n-1;
                i++;
            }
            else{
                j--;
            }
        }
        return maxLen;
    }
}