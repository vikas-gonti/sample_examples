package com.myworks;

public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1="abc";
		String s2 = new String("abc");
		System.out.println(s1.equals(s2));
		
		/*Sorting sort = new Sorting();
		int[] input = {6,7,4,1,3,8,2,5};
		sort.bubbleSort(input);
		sort.selectionSort(input);
		sort.insertionSort(input);
		sort.mergeSort(input);*/
	}
	
	

	/* Bubble Sort or Exchange Sort */
	private void bubbleSort(int[] in) {
		int length=in.length;
		for(int i=0;i<length;i++) {
			for (int j=length-1;j>i;j--){ // Compare right to left, 
				if(in[i] > in[j]) 
					exch(in,i,j);
			}
		}
		displayList(in,length);
	}
	
	/* Selection Sort */ 
	private void selectionSort(int[] in) {
		int length=in.length;
		int min;
		for(int i=0;i<length;i++) {
			min=i;
			for(int j=i+1;j<length;j++){
				if(in[min]>in[j])
					min=j;
			}
			exch(in,i,min);
		}
		displayList(in,length);
	}
	
	/* Insertion Sort */
	private void insertionSort(int[] in) {
		int length=in.length;
		for (int i=0;i<length;i++) {
			for(int j=i;j>0;j--) {
				if(in[j-1]>in[j])
					exch(in,j-1,j);
			}
		}
		displayList(in, length);
	}

	/* Merge Sort */
	private void mergeSort(int[] in) {
		divide(in,0,in.length-1);
		displayList(in,in.length);
	}
	private void divide(int[] in,int lo,int hi) {
		
		if(hi<=lo)
			return;
		int mid=lo+(hi-lo)/2;
		divide(in,lo,mid);
		divide(in,mid+1,hi);
		merge(in,lo,mid,hi);
	}
	private void merge(int[] in, int lo, int mid, int hi) {
		int[] aux=new int[in.length];
		for(int k=lo;k<=hi;k++)
			aux[k]=in[k];
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++){
			if(i>mid)
				in[k]=aux[j++];
			else if(j>hi)
				in[k]=aux[i++];
			else if(aux[i]<aux[j])
				in[k]=aux[i++];
			else
				in[k] = aux[j++];
		}
		
	}

	// Print Sorted List
	private void displayList(int[] in, int length) {
		for(int i=0;i<length;i++) {
			System.out.println(in[i]);
		}
		
	}
	
	// Exchange i and j values
	private void exch(int[] in, int i, int j) {
		int temp=in[i];
		in[i]=in[j];
		in[j]=temp;
	}
	
}
