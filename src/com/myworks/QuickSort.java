/**
 * 
 */
package com.myworks;

/**
 * @author Vikas
 * 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort sort = new QuickSort();
		char[] input = { 'Q', 'U', 'I', 'C', 'K', 'S', 'O', 'R', 'T' };
		sort.quick(input, 9);
	}

	void quick(char[] items, int count) {
		qs(items, 0, count - 1);
		displayList(items,count);
	}

	/* The Quicksort. */
	void qs(char[] items, int left, int right) {
		int i, j;
		char x, y;
		i = left;
		j = right;
		x = items[(left + right) / 2];
		do {
			while ((items[i] < x) && (i < right))
				i++;
			while ((x < items[j]) && (j > left))
				j--;
			if (i <= j) {
				y = items[i];
				items[i] = items[j];
				items[j] = y;
				i++;
				j--;
			}
		} while (i <= j);
		exch(items, left, j);
		
		if(left < j) qs(items, left, j-1);
		if(i < right) qs(items, j+1, right);
	}
// program princeton
	public static void sort(int[] a) {
		
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while (true) {
			while ((a[++i]< a[lo]))
				if (i == hi)
					break;
			while ((a[lo] < a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private void displayList(char[] in, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(in[i]);
			
		}
		System.out.println("");

	}
	// Exchange i and j values
	private void exch(char[] in, int i, int j) {
		char temp=in[i];
		in[i]=in[j];
		in[j]=temp;
	}
	
	private static void exch(int[] in, int i, int j) {
		int temp=in[i];
		in[i]=in[j];
		in[j]=temp;
	}

}
