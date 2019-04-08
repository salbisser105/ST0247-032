/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago_Albisser
 */
public class Taller10 {
    public static int subs(String init, String fin){
	int[][] tabla =  new int[init.length()+1][fin.length()+1];
	for(int i = 0; i <= fin.length();i++){
		tabla[0][i] = 0;
        }
	for(int i = 0; i <= init.length(); i++){
		tabla[i][0] = 0;
	}
	for(int i = 1; i <= init.length(); i++){
		for(int j = 1; j <= fin.length(); j++){
			if(init.charAt(i-1) == fin.charAt(j-1)){
				tabla[i][j] = tabla[i-1][j-1] + 1;
			}else if(init.charAt(i-1) != fin.charAt(j-1)){
				tabla[i][j] = Math.max(tabla[i][j-1], tabla[i-1][j]);
			}
			
		}
	}
	return tabla[init.length()][fin.length()];
    }
}
