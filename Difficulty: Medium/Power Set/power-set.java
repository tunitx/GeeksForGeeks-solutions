//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        //date : 14th july 2024
        
        List<String> list = new ArrayList<String>();
        
        double totalSubsets = Math.pow(2, s.length());
        
        for(int counter =1; counter<totalSubsets; counter++){
            
            String str = "";
            
            for(int j =0; j <s.length(); j++){
                if((counter&(1<<j))!=0) str+=s.charAt(j);
            }
             list.add(str);
            
        }
        
        Collections.sort(list);
        
        return list;
    }
}