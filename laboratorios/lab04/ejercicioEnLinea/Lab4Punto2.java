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
public class Lab4Punto2 {

    public static void read(){

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        while (x!=0){
            int y = in.nextInt();
            int z = in.nextInt();
            int [] manana = new int[x];
            int [] tarde = new int[x];
            int horaExtra = 0; 
            int pagoExtra=0;
            for (int i = 0; i < x; i++){
                manana[i]= in.nextInt();
            }
            for (int i = 0; i < x; i++){
                tarde[i]= in.nextInt();
            }
            Arrays.sort(tarde);
            Arrays.sort(manana);
            for (int i = 0; i < x; i++){
                horaExtra += (manana[i]+tarde[x-i-1]) - y;
            }
            pagoExtra = horaExtra * z;
            System.out.println(pagoExtra);
            x = in.nextInt();
        }

    }
}
