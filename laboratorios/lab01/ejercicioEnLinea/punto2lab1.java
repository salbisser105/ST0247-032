/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorios;

/**
 *
 * @author Usuario
 */
import java.util.*;
public class punto2lab1 {
    public boolean esColoreableP(ArrayList<LinkedList<Integer>> grafo)
    {
	int [] yaColor = new int[grafo.size()];
	int i = 0;
	while(i < yaColor.length)
	    {
		yaColor[i] = -1;
		i++;
	    }
	yaColor[0] = 1;
	boolean es =  auxE(grafo, yaColor);
	return es;
    }

    private boolean auxE(ArrayList<LinkedList<Integer>> grafo, int [] color)
    {
	Stack<Integer> recorridos =  new Stack<>();
        
	recorridos.push(0);
	while(!recorridos.isEmpty())
	    {
		int actual = recorridos.pop();
		if(grafo.get(actual).contains(actual) == true) return false;
		for(int i = 0; i < grafo.get(actual).size(); i++)
		    {
			int j = grafo.get(actual).get(i);
			if(color[j] == -1)
			    {
				color[j] = 1-color[actual];
				recorridos.push(j);
			    }else if(color[actual] == color[j]) return false;
		    }
	    }
	return true;
    }

    public boolean esColoreable(int [][] grafo)
    {
        
	int [] yaColor = new int[grafo.length];
	int i = 0;
	while(i < yaColor.length)
	    {
		yaColor[i] = -1;
		i++;
	    }
	yaColor[0] = 1;
	boolean es =  aux(grafo, yaColor);
	return es;
    }


    private boolean aux(int [][] grafo, int [] color)
    {
	Stack<Integer> recorridos =  new Stack<>();
        
	recorridos.push(0);
	while(!recorridos.isEmpty())
	    {
		int actual = recorridos.pop();
		if(grafo[actual][actual] == 1) return false;
		for(int i = 0; i < grafo.length; i++)
		    {
			if(grafo[actual][i] == 1 && color[i] == -1)
			    {
				color[i] = 1-color[actual];
				recorridos.push(i);
			    }else if(grafo[actual][i] == 1  && color[actual] == color[i]) return false;
		    }
	    }
	return true;
    }
}
