//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int [] ans = new int [2];
        Arrays.sort(arr);
        ans [0] = findFloor(arr, x);
        ans[1] = findCeil(arr, x);
        return ans;
    }
    public int findFloor(int [] arr , int x){
        int ans = -1, low =0, high = arr.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == x ) return arr[mid];
            else if (arr[mid]>x) high = mid -1;
            else {
                ans = mid;
                low = mid +1;
            }
        }
        return ans!=-1 ? arr[ans] : -1;
    }
    
    public int findCeil(int [] arr, int x){
        int ans = -1, low =0, high = arr.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == x) return arr[mid];
            else if(arr[mid]<x) low = mid +1;
            else {
                ans = mid;
                high = mid -1;
            }
        }
        return ans !=-1 ? arr[ans] : -1;
    }
    
}
