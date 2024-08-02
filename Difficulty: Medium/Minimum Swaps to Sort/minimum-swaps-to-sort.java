//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends

 class Solution {
    public int minSwaps(int nums[]) {
        // Create a list of lists where each inner list contains [num, index]
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new ArrayList<>(Arrays.asList(nums[i], i)));
        }

        // Sort the list by the first element (the value in nums)
        Collections.sort(list, (a, b) -> Integer.compare(a.get(0), b.get(0)));

        int res = 0;
        Boolean[] visited = new Boolean[nums.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || list.get(i).get(1) == i) {
                // Element is already in the correct position or already visited
                continue;
            }

            int j = i;
            int cycleSize = 0;

            // Traverse the cycle
            while (!visited[j]) {
                visited[j] = true; // Mark as visited
                j = list.get(j).get(1); // Move to the next index in the cycle
                cycleSize++;
            }

            // If there is a cycle of size > 1, add (cycleSize - 1) to result
            if (cycleSize > 1) {
                res += (cycleSize - 1);
            }
        }
        
        return res;
    }
}
