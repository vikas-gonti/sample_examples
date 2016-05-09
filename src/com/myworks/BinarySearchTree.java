package com.myworks;

import java.util.LinkedList;
import java.util.Queue;
 
// Binary Search Class
public class BinarySearchTree<Key extends Comparable<Key>,Value> {

	private Node root;
	
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int count;
		public Node(Key key, Value val)
		{
			this.key = key;
			this.val = val;
		}
	}
	
	
	public Value get(Key key) {  // get Value
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
	
	public void put(Key key, Value val) { // Put Value in tree
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else if (cmp == 0)
			x.val = val;
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		return x.count;
	}

	public Key floor(Key key) {  // get floor Largest Key<= given key 
		Node x = floor(root, key); // ceiling smallest key >= given key
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}
	
	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node x) {
		if (x == null)
			return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if (cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else if (cmp == 0)
			return size(x.left);
		return 0;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> q = new LinkedList<Key>();
		inorder(root, q);
		return q;
	}

	private void inorder(Node x, Queue<Key> q) {
		if (x == null)
			return;
		inorder(x.left, q);
		q.remove(x.key);
		inorder(x.right, q);
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	private Node min(Node x) {
		if(x == null)
			return null;
		if(x.left == null)
			return x;
		min(x.left);
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst= new BinarySearchTree();
		bst.put(1, 1);
		bst.put(2, 2);
		bst.get(2);

	}

}
