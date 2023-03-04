//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int arr[], int size)
    {
        // your code here
        int min = Integer.MAX_VALUE;
        int min_yet = 0;
        for(int i =0; i<arr.length; i++){
            min_yet +=arr[i];
            min = Math.min(min, min_yet);
            if(min_yet>0){
                min_yet =0;
            }
        }
        return min;
    }
}