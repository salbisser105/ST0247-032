/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago_Albisser
 */
public class Taller9 {
    public static int levenshtein(String a, String b) {
	    int longA = a.length();
	    int longB = b.length();
	    int[][] results = new int[longA+1][longB+1];
	    for(int i = 0; i <= longA; i++){
                results[i][0] = i;
            }
	    for(int i= 0;i <= longB; i++ ){
                results[0][i] = i;
            }
	    for(int i = 1; i <= longA; i++) {
		    for(int j = 1; j<= longB;j++){
			    if(a.charAt(i-1) == b.charAt(j-1)){
				results[i][j] = results[i-1][j-1];
                            }else{
                                results[i][j] = Math.min(Math.min(results[i-1][j]+1, results[i][j-1]+1), results[i-1][j-1]+1);
                            }
                    }
            }
	    return results[longA][longB];
    }
}
