/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author **
 */
import java.util.*;
public class Laboratorio4 {
    
    public static int salesman(Digraph g){
        int res = 0;
        int minCost = Integer.MAX_VALUE;
        int x = 0;
        boolean[]visited = new boolean[g.size];
        while(x!=g.size-1){
            ArrayList<Integer>successors = g.getSuccessors(x);
            for(int i = 0; i < successors.size(); i++){
                if(visited[i] == false && g.getWeight(x, successors.get(i)) < minCost){
                    minCost = g.getWeight(x, successors.get(i));
                    x = successors.get(i);
                    visited[i] = true;
                }
            }
            res += g.getWeight(x, successors.get(x));
        }
        return res;
    }
}
