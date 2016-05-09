package com.myworks;

import java.util.Stack;

public class DepthFirstPaths {

	
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
    private int count;           // number of vertices connected to s

	public DepthFirstPaths(Graph G, int s)  // find paths in G from source s
	{
		// Initialize marked and edgeTo
		this.s = s;
        edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			}
	}
	
	public boolean hasPathTo(int v) {   // Is there a path from s to v
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {   // Path from s to v , null of there is no such path
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
