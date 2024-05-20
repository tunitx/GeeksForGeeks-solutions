//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Solution
// {
//     // arr[]: Input Array
//     // N : Size of the Array arr[]
//     //Function to count inversions in the array.
//     static long count =0;
//     static long inversionCount(long arr[], long N)
//     {
//         // Your Code Here
//          count =0;
//         mergeSort(arr, 0, arr.length-1);
//         return count;
//     }
//     static void mergeSort(long [] arr, int start, int end ){
        
       
//         if(start<end){
//             int mid = (start+end)/2;
//             mergeSort(arr,start, mid );
//           mergeSort(arr, mid+1, end);
            
//             merge(arr, start, end, mid);
//         }
//         else return;
        
//     }
    
//     static long merge(long [] arr, int start, int end, int mid ){
//         int n1 = mid +1-start;
//         int n2 = start-mid;
//         long count =0;
//         long [] left = new long[n1];
//         long [] right = new long[n2];
        
//         for(int i =0; i<n1; i++){
//             left[i] = arr[start+i];
//         }
//         for(int j=0; j<n2; j++){
//             right[j] = arr[mid+1+j];
//         }
        
//         int i =0, j=0;
//         int k =start;
        
//         while(i<n1 && j<n2){
//             if(left[i]<=right[j]){
//                 arr[k++] = left[i];
//                 i++;
//             }
//             else{
//                 count +=(n1-i);
//                 arr[k++] = right[j];
//                 j++;
//             }
//         }
        
//         while(i<n1){
//             arr[k++] = left[i++];
//         }
//         while(j<n2){
//             arr[k++] = right[j++];
//         }
//         return count;
        
        
//     }
// }
class Solution {
    // Function to count inversions in the array.
    static long count = 0;
    
    static long inversionCount(long arr[], long N) {
        count = 0; // Reset count
        mergeSort(arr, 0, (int) N - 1);
        return count;
    }
    
    static void mergeSort(long[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
    }
    
    static void merge(long[] arr, int start, int end, int mid) {
        int n1 = mid - start + 1; // Correct calculation of left subarray size
        int n2 = end - mid; // Correct calculation of right subarray size

        long[] left = new long[n1];
        long[] right = new long[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;
        
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (n1 - i); // Count inversions
            }
        }
        
        while (i < n1) {
            arr[k++] = left[i++];
        }
        
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
