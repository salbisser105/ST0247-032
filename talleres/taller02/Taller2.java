/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.*;
/**
 *
 * @author cl18417
 */
public class Taller2 {
    /**
	* Metodo auxiliar que llama al metodo combinations posterios
	* 
	* @param  s el conjunto sobre el cual se haran las combinaciones
	
	*/	
	public static ArrayList<String> combinations(String s) {
            ArrayList<String> p = new ArrayList<>();
            return combinations("", s, p);
	}

	/**
	* Metodo para obtener las posibles combinaciones que se pueden hacer
	* con los elementos dados
	* 
	* @param  x lleva la posicion para recorrer el conjunto 
	* @param list el conjunto que tiene todas las combinaciones
	* @param s la cadena actual
	* 
	*/	
	private static ArrayList<String> combinations(String s, String x, ArrayList<String> list) {
            if(x.length() == 0){
		list.add(s);
	    }else{   
		combinations(s+x.charAt(0), x.substring(1), list);
		combinations(s, x.substring(1), list);
	    }
            return list;
	}

	/**
	* Metodo auxiliar que llama al metodo permutations posterios
	* 
	* @param  s la cadena a la cual se le haran las permutaciones
	* @return un ArrayList que contiene las permutaciones
	*/	
	public static ArrayList<String> permutations(String s) {
            ArrayList<String>list = new ArrayList<>();
            permutations("",s,list);
            return list;
	}

	/**
	* Metodo para obtener las posibles permutaciones que se pueden hacer
	* con los caracteres de una cadena dada, recuerde que las letras no se 
	* repiten en este ejercicio
	* 
	* @param  pre parte de la cadena que empieza desde 0 a i
	* @param pos parte de cadena que empieza desde i a n
	* @param list el conjunto que tiene todas las permutaciones
	* 
	*/	
	private static void permutations(String pre, String pos, ArrayList<String> list) {
            if(pos.length() == 0){
	    //System.out.println(pre);
	    list.add(pre);
            }else{
                for(int i = 0; i < pos.length(); ++i ){
                    permutations(pre+pos.charAt(i), pos.substring(0,i)+pos.substring(i+1), list);
                }
            }
        }

	/**
	* Metodoque imprime en pantalla como esta el tablero dado
	* 
	* @param  tablero es un arreglo con las posiciones de un tablero
	* de ajedrez
	* no se modifica.
	*/	
	public static void imprimirTablero(int[] tablero) {
		int n = tablero.length;
		System.out.print("    ");
		for (int i = 0; i < n; ++i)
			System.out.print(i + " ");
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(i + "   ");
			for (int j = 0; j < n; ++j)
				System.out.print((tablero[i] == j ? "Q" : "#") + " ");
			System.out.println();
		}
		System.out.println();
	}
}
