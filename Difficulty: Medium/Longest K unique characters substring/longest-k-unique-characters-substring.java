//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int start =0;
        Map<Character, Integer> map = new HashMap<>();
        int ans =-1;
        for(int end =0; end < s.length(); end ++){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            while(map.size() >k && start<end){
                char ch2 = s.charAt(start);
                map.put(ch2, map.get(ch2)-1);
                if(map.get(ch2) ==0) map.remove(ch2);
                start++;
            }
            if(map.size()==k) ans = Math.max(ans, end-start+1);
        }
        return ans;
    }
}