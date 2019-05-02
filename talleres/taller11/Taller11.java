/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author cl18417
 */
public class Taller11 {
    public static int heldKarp(Digraph g) {
	    int n = g.size();
	    int[][] cost = new int[n] [(int) Math.pow(2,n)];
	    int[][] ant = new int[n] [(int) Math.pow(2,n)];
	    for(int i = 0; i < n; i++) {
	        cost[i][0] = g.getWeight(0,i);
	        ant[i][0] = 0;
	    }
	    for (int i = 0; i < n; i++) {
	       for (int j = 0; j < n; j++) {
	           cost[][];
	           ant[][];
	       }
	    }
	           
	    return cost[0][Math.pow(2,n);
	}
}
