//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String s, int k) {
        // your code here
        // date : 17 oct 2024
        
        return helper(s, k) - helper(s, k-1);
      
    }
    
    long helper(String s, int k){
          HashMap<Character, Integer> map = new HashMap<>();
        
        int start =0, end =0;
        long count =0;
        
        while(end < s.length()){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            while(map.size() > k){
                char start_ch = s.charAt(start);
                map.put(start_ch, map.get(start_ch)-1);
                if(map.get(start_ch)==0) map.remove(start_ch);
                start++;
            }
            
             count += end - start+1;
            end ++;
        }
        return count;
    }
}
