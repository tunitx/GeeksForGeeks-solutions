<h2><a href="https://practice.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article">Distribute candies in a binary tree</a></h2><h3>Difficulty Level : Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a binary tree with N nodes, in which each node value represents number of candies present at that node. In one move, one may choose two adjacent nodes and move one candy from one node to another (the move may be from parent to child, or from child to parent.)&nbsp;<br>
The task is to find the number of moves required such that every node have&nbsp;<strong>exactly one</strong>&nbsp;candy.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input </strong>:      3
           /   \
          0     0 
<strong>Output : </strong>2
<strong>Explanation</strong>: 
From the root of the tree, we move one 
candy to its left child, and one candy to
its right child.
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input </strong>:      0
           /   \
          3     0  
<strong>Output : </strong>3
<strong>Explanation </strong>: 
From the left child of the root, we move 
two candies to the root [taking two moves]. 
Then, we move one candy from the root of the 
tree to the right child.</span></pre>

<div><span style="font-size:18px"><strong>Your task :</strong></span></div>

<div><span style="font-size:18px">You don't have to read input or print anything. Your task is to complete the function<strong> distributeCandy()</strong> which takes the root of the tree as input and returns the number of moves required&nbsp;such that every node has&nbsp;exactly one&nbsp;candy.</span></div>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Expected Time Complexity</strong>: O(n)</span></div>

<div><span style="font-size:18px"><strong>Expected Auxiliary Space</strong>: O(h)</span></div>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Constraints:</strong></span></div>

<div><span style="font-size:18px">1&lt;=n&lt;=10^4</span></div>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;