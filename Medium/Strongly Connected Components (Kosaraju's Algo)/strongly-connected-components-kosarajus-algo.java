//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //date : 14th may 2023
        //first step involves finding toplogical sort of the tree
        //second step involves finding tranpose of the graph
        //third step involves doing dfs traversal of the new tranpose graph according to its topological sorting
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean v [] = new boolean[V];
        for(int i =0; i <V; i++){
            if(!v[i]){
                dfs1(i, adj,stack, v);
            }
        }
        
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        
        for(int i =0; i<V; i++){
            transpose.add(new ArrayList<Integer>());
        }
        for(int i=0; i<V; i++){
            for(int j: adj.get(i)){
                transpose.get(j).add(i);
            }
        }
        int count =0;
        Arrays.fill(v, false);
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!v[node]){
                count ++;
                dfs2(node, transpose, v);
            }
        }
        return count;
    }
    public static void dfs1(int s, ArrayList<ArrayList<Integer>> adj, ArrayDeque<Integer> stack, boolean v []){
        v[s] = true;
        
        for(int i :adj.get(s)){
            if(!v[i]){
                dfs1(i, adj, stack, v);
            }
        }
        stack.push(s);
    }
    public static void dfs2(int s, ArrayList<ArrayList<Integer>> transpose, boolean v []){
        v[s] = true;
        
        for(int i : transpose.get(s)){
            if(!v[i]){
                dfs2(i, transpose, v);
            }
        }
    }
}
