//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        // date : 20 oct 2024
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int start =0, res =0, k=2;
        
        for(int end =0; end<arr.length; end++){
            int num = arr[end];
            map.put(num, map.getOrDefault(num,0)+1);
            
            if(map.size()>2){
                while(start<end && map.size()>2){
                    map.put(arr[start], map.get(arr[start])-1);
                    if(map.get(arr[start])==0)
                        map.remove(arr[start]);
                    start++;
                }
            }
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}