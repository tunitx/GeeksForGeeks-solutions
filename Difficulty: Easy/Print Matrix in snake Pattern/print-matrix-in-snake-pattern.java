//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.snakePattern(matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here 
        // date : 2-august  2024
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        Boolean notSnake = true;
        Boolean snake = false;
        int start =0;
        int end=0;
        for(int i =0; i<matrix.length; i++){
            
            for(int j=0; j<matrix[0].length; j++){
                ans.add(matrix[i][j]);
                end++;
            }
            if(notSnake) {
                snake = true;
                notSnake = false;
                // Collections.reverse(ans.subList(start, end));
                start= ans.size();
                end= start;
            }
          else {
              snake = false;
              notSnake = true;
              Collections.reverse(ans.subList(start, end));
              start = ans.size();
              end = start;
          }
        }
        return ans;
        
        
    }
}