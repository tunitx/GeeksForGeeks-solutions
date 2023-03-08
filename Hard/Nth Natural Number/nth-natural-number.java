//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    

// } Driver Code Ends


//User function Template for Java

class Solution {
    long findNth(long N)
    {
        //code here
        long k = 1;
        long ans = 0;
        while(N>0){
            ans += (k*(N%9));
            N/=9;
            k*=10;
        }
        return ans;
    }
}