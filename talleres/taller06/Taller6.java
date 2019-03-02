/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import java.util.*;
public class Taller6 {
    
    public static int[] cambioGreedy(int n, int[] denominaciones) {
	int[] aux = new int[denominaciones.length];
	int i = 0;
	while(i < denominaciones.length ){
            if(n-denominaciones[i] >= 0){
                aux[i] = aux[i] + 1 ;
                n = n - denominaciones[i];
            } if(n-denominaciones[i] < 0){
                i++;
            }
        }
	if(n != 0){
            return null;
        }
	return aux;
    }
    
    public static int recorrido(Digraph g) {
        boolean[] visitados = new boolean[g.size()];
        int val = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < g.size(); i++) {
            int min = Integer.MAX_VALUE;
            visitados[x] = true;
            ArrayList<Integer> list = g.getSuccessors(x);
            
            for(Integer a : list) {
                int weight = g.getWeight(x, a);
                if((!visitados[a] && weight < min) || (i==g.size()-1 && a==0)) {
                    min = weight;
                    y = a;
                }
            }
            val += min;
            x = y;
        }

        return val;
    }
}
