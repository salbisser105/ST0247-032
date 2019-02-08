/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago_Albisser
 * Juan Pablo Leal
 */
import java.util.ArrayList;

import java.util.Collections;





public class Taller3 {



	

    private static boolean puedoPonerReina(int[] tablero) {

	for(int o = 0; o < tablero.length; o++)

	    for(int m = o+1; m < tablero.length; m++)

		if(tablero[o] == tablero[m] || Math.abs(tablero[o]-tablero[m]) == Math.abs(o-m))

		    return true;

	return false;

    }

	



    public static int nReinas(int n) {

	int resultado = 0;

	int [] tablero = new int[n];

	ArrayList<int []> num =  new ArrayList<>();

	nReinas( 0, tablero, num);

	return num.size();

    }

	

    private static void nReinas(int a, int[] tablero, ArrayList<int []> num) {

	if(a == tablero.length)

	    {

		if(!puedoPonerReina(tablero))

		    {

			num.add(tablero);

		    }

	    }else

	    {

		for(int e = 0; e < tablero.length; e++)

		    {

			tablero[a] = e;

			nReinas(a+1, tablero, num);

		    }

	    }

    }

	

    public static void imprimirTablero(int[] tablero) {

	int d = tablero.length;

	System.out.print("    ");

	for (int b = 0; b < d; ++b)

	    {

		System.out.print(b + " ");

	    }

	System.out.println("\n");

	for (int c = 0; c < d; ++c) {

	    System.out.print(c + "   ");

	    for (int x = 0; x < d; ++x)

		{

		    System.out.print((tablero[c] == x ? "Q" : "#") + " ");

		}

	    System.out.println();

	}

	System.out.println();

    }


    public static void main(String[] args)

    {
	System.out.println(nReinas(4));

    }



}
