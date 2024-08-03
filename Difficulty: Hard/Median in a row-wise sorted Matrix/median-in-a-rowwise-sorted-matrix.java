//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    int median(int mat[][], int r, int c) {
        // code here  
        	int min = mat[0][0], max = mat[0][c-1];
	for (int i=1; i<r; i++)
	{
		if (mat[i][0] < min)
			min = mat[i][0];

		if (mat[i][c-1] > max)
			max = mat[i][c-1];
	}

	int medPos = (r * c + 1) / 2;
	while (min < max)
	{
		int mid = (min + max) / 2;
		int midPos = 0;
        int pos = 0;
		for (int i = 0; i < r; ++i){
			    pos = Arrays.binarySearch(mat[i],mid);
                
                if(pos < 0)
                    pos = Math.abs(pos) - 1;
                  
                
                else
                {
                    while(pos < mat[i].length && mat[i][pos] == mid)
                        pos += 1;
                }
                  
                midPos = midPos + pos;
		}
		if (midPos < medPos)
			min = mid + 1;
		else
			max = mid;
	}
	return min;
    }
}