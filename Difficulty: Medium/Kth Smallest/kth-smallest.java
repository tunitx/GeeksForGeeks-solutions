//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        
        // date : 31st july 2024
        if(l>r){
            return l-1;
        }
       
        
       
            int pivot = lomuto(arr, l, r,k);
            if(pivot== k-1) return arr[pivot];
            
            if(pivot > (k-1)) return kthSmallest(arr, l, pivot-1, k);
            return kthSmallest(arr,pivot+1, r, k);
        
        
        
    }
    
   static int lomuto(int [] arr, int low, int high, int k){
        int pivot = arr[high];
        int j = low-1;
        
        for(int i =low; i<=high-1; i++){
            if(arr[i]<pivot){
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[j+1];
        arr[j+1] = arr[high];
        arr[high] = temp;
        
        return j+1;
        
    }
}
