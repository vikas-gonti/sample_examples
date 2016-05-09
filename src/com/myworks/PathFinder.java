package com.myworks;

import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {

	private Queue<Coordinator> queue;

	public class Coordinator {
		int x;
		int y;

		public Coordinator(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public PathFinder() {
		queue = new LinkedList<Coordinator>();
	}

	char[][] maze = { { 'a', 'b', 'c', 'd', 'e' }, 
					  { 'f', 'g', 'h', 'i', 'j' },
					  { 'k', 'l', 'm', 'n', 'o' }, 
					  { 'p', 'q', 'r', 's', 't' },
					  { 'u', 'v', 'w', 'x', 'y' }, 
					  { 'z', ' ' } };

	public void setupCoordinator(String word) {
		for (int i = 0; i < word.length(); ++i) {
			queue.add(new Coordinator((word.charAt(i) - 'a') / 5, (word
					.charAt(i) - 'a') % 5));
		}
		findPath();
	}

	public void findPath(){
			Coordinator pre = new Coordinator(0,0);
			int xMove = 0;
			int yMove = 0;
			while (!queue.isEmpty()){
			     Coordinator cur = queue.poll();
			     xMove = cur.x - pre.x;
			     yMove = cur.y - pre.y;		     
			     int i = pre.x;
			     int j = pre.y;
			     if (xMove >0){
			    	 for (i = pre.x+1 ; i<=pre.x + xMove;++i){
			    		 System.out.println("Down//now we are at " + maze[i][j]);
			    	 }
			    	 i-=1;
			     }else if (xMove<0){
			    	 for (i = pre.x-1; i>=pre.x - Math.abs(xMove);--i){
			    		 System.out.println("up//now we are at " + maze[i][j]);
			    	 }
			    	 i+=1;
			     }
			     
			     
	             if (yMove >0){            	 
			    	 for (j = pre.y+1 ; j<=pre.y + yMove;++j){		    		 
			    		 System.out.println("Right//now we are at " + maze[i][j]);
			    	 }
			    	 j-=1;
			     }else if (yMove<0){		    	
			    	 for (j = pre.y-1; j>=pre.y - Math.abs(yMove);--j){		    		 
			    		 System.out.println("Left//now we are at " + maze[i][j]);
			    	 }
			    	 j+=1;
			     }
	             System.out.println("OK//to select " + maze[i][j]);
	             
	             pre = cur;
			}
			
		}

	public static void main(String[] args) {
		PathFinder p = new PathFinder();
		p.setupCoordinator("yz");

	}

}
