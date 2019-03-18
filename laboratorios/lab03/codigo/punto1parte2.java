/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3punto1;

/**
 *
 * @author Usuario
 */
public class punto1parte2 {
    
    private int[] nReinas(int x, int[] tablero) {
        if (x == tablero.length) {
            if (!validar(tablero)) {
                return tablero;
            }
        } else if(x != tablero.length){
            int[] arr = new int[tablero.length];
            for (int i = 0; i < tablero.length; i++) {
                tablero[x] = i;
                arr = nReinas(x + 1, tablero);
                if(arr != null)
                {
                    return arr;
                }
            }
        }
        return null;
    }
    
    public int[] nReinas(int x) {
        int[] tablero = new int[x];
        return nReinas(0, tablero);
    }
    
    private boolean validar(int[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
