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
import java.util.*;
public class Taller5 {
    

	/**
	* Metodo que dado un grafo y un numero m, se asigna un color
	* a cada nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @return true si es posible, false de lo contrario
	*/
	public static boolean mColoring(Digraph g, int m) {
            int[]colores = new int[g.size()];
            boolean a = mColoring(g, 0, colores, m);
            return a;
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color
	* al nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean mColoring(Digraph g, int v, int[] colores, int m) {
            if(v==g.size()){
                return true;
            } else {
                for(int i=1; i<=m; i++){
                    colores[v]=i;
                    if(!isSafe(g,v,colores)){
                        return mColoring(g,v+1,colores,m);
                    }
                }
            }
            return false;
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color colors en la 
	* posicion c al nodo v, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param c indice de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean isSafe(Digraph g, int v, int[] colores) {
            ArrayList <Integer> sucesores = g.getSuccessors(v);
            for(int i=0; i<sucesores.size(); i++){
                if(colores[sucesores.get(i)]==colores[v]){
                    return true;
                }
            }
            return false;
	}
}
