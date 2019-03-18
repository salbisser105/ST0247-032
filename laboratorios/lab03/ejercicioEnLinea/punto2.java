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
import java.util.*;
public class punto2 {
    public static ArrayList valorMinimo (Digraph g) {
        boolean[] visitado = new boolean[g.size()];
        ArrayList list = new ArrayList();
        int max = Integer.MAX_VALUE;
        int sum = 0;
        boolean b = false;
        boolean a = valorMinimoAux(g, 0, visitado, b, list, sum, max);
        if (a) {
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + ", ");
            }
            System.out.print(list.get(list.size() - 1));
            return list;
        } else {
            System.out.println("-1");
            ArrayList c = new ArrayList();
            return c;
        }
    }
    
    public static boolean valorMinimoAux (Digraph g, int x, boolean[] visitado, boolean a, ArrayList list, int sum, int max) {
        if (x == g.size()-1) {
            list.add(x);
            max = sum;
            a = true;
        }
        visitado[x] = true;
        list.add(x);
        ArrayList<Integer> hijo = g.getSuccessors(x);
        for (int i=0; i<hijo.size(); i++) {
             if (!visitado[hijo.get(i)] && g.getWeight(x, hijo.get(i)) + sum < max) {
                 sum += g.getWeight(x, hijo.get(i));
                 a = valorMinimoAux(g, hijo.get(i), visitado, a, list, sum, max);
             }
        }
        visitado[x] = false;
        return a;
    }
}
