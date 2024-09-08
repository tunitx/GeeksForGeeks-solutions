//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        long low = 1, high = n, ans = 1;
        
        while(low<=high){
            long mid = low + (high-low)/2;
            
            if(mid*mid == n) return mid;
            if(mid*mid>n) high = mid -1;
            else {
                ans = mid;
                low = mid +1;
            }
        }
        return ans;
    }
}
