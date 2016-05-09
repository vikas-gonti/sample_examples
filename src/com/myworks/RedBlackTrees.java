package com.myworks;


public class RedBlackTrees<Key extends Comparable<Key>,Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		Key key;
		Value val;
		Node left, right;
		boolean color; // color of parent link
		public Node(Key key, Value val, boolean color)
		{
			this.key = key;
			this.val = val;
			this.color=color;
		}
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}
	
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else if (cmp == 0)
				return x.val;
		}
		return null;
	}
	
	private Node put(Node h, Key key, Value val) {
		if (h == null)
			return new Node(key, val, RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, val);
		else if (cmp > 0)
			h.right = put(h.right, key, val);
		else if (cmp == 0)
			h.val = val;
		if (isRed(h.right) && !isRed(h.left))              
			h = rotateLeft(h);      // Lean Left
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);       //balance 4 node
		if (isRed(h.left) && isRed(h.right))
			flipColors(h);  // flip colors
		return h;
	}
	
	private Node rotateLeft(Node h) {
		
		Node x = h.right;            
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rotateRight(Node h) {
		//assert isRed(h.left);
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private void flipColors(Node h) {  // h is the root node
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
