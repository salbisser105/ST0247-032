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
public class Taller4 {
    
    public static ArrayList<Integer> recorrido(Digraph g, int var) {
	int tamano = g.size();
 	boolean [] visitados =  new boolean[tamano];
	ArrayList<Integer> recorridos = new ArrayList<>();
	recorrido(g, var, visitados, recorridos);
	return recorridos;
    }

    private static void recorrido(Digraph g, int pos, boolean[] restantes, ArrayList<Integer> recorridos)
    {
	restantes[pos] = true;
	recorridos.add(pos);
	ArrayList<Integer> sucesores = g.getSuccessors(pos);
	if(sucesores != null)
	for(Integer sucesor : sucesores){
		if(!restantes[sucesor]){
			recorrido(g, sucesor, restantes, recorridos);
		}
	 }
    }

    public static boolean camino(Digraph g, int var, int fin) {
	int size = g.size();
 	boolean [] restantes =  new boolean[size];
	ArrayList<Integer> recorridos = new ArrayList<>();
	camino(g, var, restantes, recorridos);
	return recorridos.contains(fin);
    }

    private static void camino(Digraph g, int var, boolean[] restantes, ArrayList<Integer> recorridos)
    {
	restantes[var] = true;
	recorridos.add(var);
	ArrayList<Integer> sucesores = g.getSuccessors(var);
	if(sucesores != null)
	for(Integer sucesor : sucesores){
		if(!restantes[sucesor]){
			camino(g, sucesor,restantes, recorridos);
		}
	}
    }
}
