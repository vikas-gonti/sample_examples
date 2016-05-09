package com.myworks;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

	public BreadthFirstPaths(Graph G, int s)
	{
		marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);

	}

	private void bfs(Graph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		distTo[s] = 0;
		marked[s] = true;
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.remove();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					q.add(w);
					marked[w] = true;
					distTo[w] = distTo[v] + 1;
					edgeTo[w] = v;
				}
			}
		}
	}
	
	 public boolean hasPathTo(int v) {  // Is there a path between the source vertex s and vertex v
	        return marked[v];
	    }
	 
	/* returns the number of edges in a shortest path between the source vertex <tt>s</tt>
     * (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return the number of edges in a shortest path
     */
    public int distTo(int v) {
        return distTo[v];
    }
    
    /**
     * Returns a shortest path between the source vertex <tt>s</tt> (or sources)
     * and <tt>v</tt>, or <tt>null</tt> if no such path.
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
