//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Map.Entry; 


// } Driver Code Ends
//User function Template for Java

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int arr1[], int N, int arr2[], int M)
    {
        //Your code here
          HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            m.put(arr1[i],m.getOrDefault(arr1[i],0)+1);
        }
        int k =0;
        for (int i = 0; i <arr2.length ; i++) {
            if(m.containsKey(arr2[i])){
                int j =0;
                while(j<m.get(arr2[i])){
                    arr1[k] = arr2[i];
                    k++;
                    j++;
                }
                m.remove(arr2[i]);
            }

        }
         int n = k;
     for (Map.Entry<Integer,Integer>e: m.entrySet()){
         for (int i = 0; i <e.getValue() ; i++) {
             arr1[k] = e.getKey();
             k++;
         }
            // m.remove(e.getKey());
     }
     Arrays.sort(arr1, n,arr1.length);
     return arr1;
    }
}



//{ Driver Code Starts.
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a1[]=new int[n];
		    int a2[]=new int[m];
		    
		    for(int i=0;i<n;i++)
		    a1[i]=sc.nextInt();
		    
		    for(int i=0;i<m;i++)
		    a2[i]=sc.nextInt();
		    Solution ob=new Solution();
		    a1 = ob.sortA1ByA2(a1,n,a2,m);
		    for(int x:a1)
		    System.out.print(x+" ");
		    
		    System.out.println();
		}
	}
	

}



// } Driver Code Ends