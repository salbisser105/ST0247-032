/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import java.util.Scanner;
public class lab5punto2 {
    public static void read () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair<Integer, Integer>[] coordenadas;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair<Integer, Integer> pos = new Pair<>(x,y);
            int desechos = sc.nextInt();
            DigraphAM graph = new DigraphAM(desechos + 1);
            coordenadas = new Pair[desechos + 1];
            coordenadas[0] = pos;
            for (int j = 1; j <= desechos; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                coordenadas[j] = new Pair(a,b);
            }
            for (int k = 0; k <= desechos; k++) {
                for (int j = 0; j <= desechos; j++) {
                    if (k == j) {
                    }
                    graph.addArc(k, j,Math.abs(coordenadas[k].first - coordenadas[j].first)+ Math.abs(coordenadas[k].second - coordenadas[j].second));
                }
            }
        }

    }
}
