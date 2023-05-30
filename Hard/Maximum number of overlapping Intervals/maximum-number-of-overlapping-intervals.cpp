//{ Driver Code Starts
/* Driver program to test above function */

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution{
    public:
    int overlap(vector<pair<int,int>>intervals, int n){
        //Write your code here
         sort(begin(intervals), end(intervals));
        priority_queue<int, vector<int>, greater<int>> ends;
        size_t result = 0;
        for (const auto& interval : intervals) {
            ends.push(interval.second);
            while (interval.first > ends.top()) ends.pop();
            result = max(result, ends.size());
        }
        return result;
    }
};



//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin >> n;
	    vector<pair<int,int>>intervals;
	    for(int i = 0; i < n; i++){
	        int a, b;
	        cin >> a >> b;
	        intervals.push_back({a, b});
	    }
	    Solution ob;
	    int ans = ob.overlap(intervals, n);
	    cout << ans <<endl;
	}
	return 0;
}

// } Driver Code Ends