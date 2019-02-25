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
public class Laboratorio2 {
    
    /**
     * metodo que recibe un string para aplicar sobre el las permutaciones posibles
     * @param s string al cual se le aplican las permutaciones posibles
     * @return una lista con todas las permutaciones sobre el string recibido
     */
    public static ArrayList<String> permutations(String s) {
        ArrayList<String> r = new ArrayList<>();
        permutations("", s, r);
        return r;
    }
    /**
     * Este es un metodo auxiliar para calcular las permutaciones mediante el 
     * uso de la recursion, desglozando la cadena original en una especie de arbol para llegar a todas
     * las permutaciones
     * @param pre string el cual actua como acumulador
     * @param pos cadena original la cual se va recortando
     * @param list lista en la cual se guardan las permutaciones
     */
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if (pos.length() == 0) {
            list.add(pre);
        } else {
            for (int i = 0; i < pos.length(); ++i) {
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1), list);
            }
        }
    }
    
    /**
     * Este metodo hace uso del metodo de permutaciones, para asi despues comprobar cual tablero
     * cumple con las condiciones para el problema e las nReinas que consiste en ubiacarlas sin que se ataquen
     * @param num el numero de tipo int es el numero de reinas y por consiguiente del tablero o arreglo
     * @return el numero de soluciones
     */
    public static int reinas(int num) {
        if (num != 0) {
            int res = 0;
            String x = "";
            int[] tablero = new int[num];
            for (int i = 0; i < num; i++) {
                x = x + i;
            }
            ArrayList<String> list = new ArrayList<>();
            list = permutations(x);

            for (int j = 0; j < list.size(); j++) {
                String str = list.get(j);
                for (int i = 0; i < str.length(); i++) {
                    tablero[i] = Integer.parseInt(str.charAt(i) + "");
                }
                if (valid(tablero) == true) {
                    res = res + 1;
                }
            }
            return res;
        } else {
            return -1;
        }
    }
    
    public static boolean valid(int[] tablero) {   
        for (int i = 0; i < tablero.length; i++) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
