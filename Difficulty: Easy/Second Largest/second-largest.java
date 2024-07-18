//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Solution ob = new Solution();
            int ans = ob.print2largest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int print2largest(List<Integer> arr) {
        // Code Here
        
        //date : 18th july 2024
        
        int res  = -1;
        int largest = arr.get(0);
        
        for(int i =1; i<arr.size(); i++){
            if(arr.get(i)>largest){
                res = largest;
                largest = arr.get(i);
            }
            else if (arr.get(i)!=largest){
                if(res == -1 || arr.get(i)>res){
                    res = arr.get(i);
                }
            }
        }
        return res;
    }
}