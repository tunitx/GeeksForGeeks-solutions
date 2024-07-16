//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
  public List<String> find_permutation(String S) {
        List<String> list = new ArrayList<>();
        boolean[] used = new boolean[S.length()];
        helper(S, "", list, used);
        Collections.sort(list);
        return list;
    }

    private void helper(String str, String curr, List<String> list, boolean[] used) {
        if (curr.length() == str.length()) {
            if (!list.contains(curr)) {
                list.add(curr);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                helper(str, curr + str.charAt(i), list, used);
                used[i] = false; // Backtrack
            }
        }
    }

    
}