/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago_Albisser
 */
import java.util.*;
public class Taller7 {
    
    public int[] llenarArreglo(int n){
        int[] x = new int[n];
        Arrays.fill(x, Integer.MAX_VALUE);
        return x;
    }

    private int menorNoVisitado(Digraph g, boolean[] visitados, int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            if(!visitados[i]&& min <= arr[i])
                min = arr[i];
        }
        return min;
    }

    private void cambiarValorActual(Digraph g, int actual, int[] arr){
        for(int dest: g.getSuccessors(actual)){
            if(arr[dest] != Integer.MAX_VALUE){
                arr[dest] += g.getWeight(actual, dest);
            }
            else{
                arr[dest] = g.getWeight(actual,dest);
            }
        }
    }

    public int[] dijkstra(Digraph g, int x){
        int[] arr = llenarArreglo(g.size());
        int actual = x;
        boolean[] visitados = new boolean[g.size()];
        for (int i = 0; i < g.size(); i++) {
            actual = menorNoVisitado(g, visitados, arr);
            visitados[actual] = true;
            cambiarValorActual(g, actual, arr);
        }
        return arr;
    }

    private int prim(Digraph g, int start) {
        int total = 0;
        boolean[] visitados = new boolean[g.size()];
        ArrayList<Integer> padre = new ArrayList();
        for(int i = 0; i < g.size()-1; i++) {
            visitados[start] = true;
            int min = Integer.MAX_VALUE;
            padre.add(start);
            for(Integer nodo : padre) {
                ArrayList<Integer> hijos = g.getSuccessors(nodo);
                for(Integer hijo : hijos) {
                    if(!visitados[hijo] && g.getWeight(nodo, hijo) < min) {
                        min = g.getWeight(nodo, hijo);
                        start = hijo;
                    }
                }
            }
            total += min;
        }
        return total;
    }
}
