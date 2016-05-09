package com.myworks.MST;

import java.util.LinkedList;
import java.util.Queue;

public class KruskalMST {
	private Queue<Edge> mst = new LinkedList()<Edge>();

	public KruskalMST(EdgeWeightedGraph G) {
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges())
			pq.insert(e);
		UF uf = new UF(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				mst.enqueue(e);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}
}