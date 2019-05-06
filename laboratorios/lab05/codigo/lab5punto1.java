/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class lab5punto1 {
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
	           if (i == j) {
                    cost[i][j] = 0;
                } else {
                    int x = (j - 1) - i;
                    if (j > n && x > 0 && x < n) {
                        cost[i][j] = 0;
                        cost[x][j] = 0;
                    } else {
                        if (j < n) {
                            cost[i][j] = cost[j][0] + g.getWeight(j, i);
                        }else{
                            int y=j-i;
                            int z=j-y-1;
                            cost[i][j] = Math.max(cost[y][z]+g.getWeight(y,i),cost[z][y]+g.getWeight(z,i));
                        }
                    }
                }

	       }
	    } 
	    return cost[0][(int)Math.pow(2,n-1)];
	}
}
