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
        int [] max = new int[n];
        int maxE= Integer.MIN_VALUE;
        for(int i =n-1; i>=0; i--){
            maxE = Math.max(maxE, arr[i]);
            max[i] = maxE;
        }
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