package proyectofinal;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Implementacion de un algoritmo para asignar vehiculos compartidos
 * Estructura de datos utilizada: Grafo con Matrices de Adyacencia
 * Complejidad: Peor Caso y Mejor Caso O(n*n)
 *
 * @author Mauricio Toro
 * @version 1
 */


public class VehiculosCompartidos
{
    /**
    * Metodo para leer un archivo con los duenos de vehiculos y la empresa
    * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de vehiculos y la empresa
    *
    * @param  numeroDePuntos  El numero de puntos es 1 de la empresa y n-1 de los duenos de vehiculos
    * @return un grafo completo con la distancia mas corta entre todos los vertices
    */
    public static DigraphAM leerArchivo(int numeroDePuntos, float p){
          final String nombreDelArchivo = "dataset-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
          DigraphAM grafo = new DigraphAM(numeroDePuntos);
          try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 4; i++) // Descarta las primeras 3 lineas
                lineaActual = br.readLine();
            lineaActual = br.readLine(); 
            for (int i = 1; i <= numeroDePuntos; i++){ //Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }          
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas
                lineaActual = br.readLine();             
            while (lineaActual != null){ // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String [] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0])-1, Integer.parseInt(cadenaParticionada[1])-1, Integer.parseInt(cadenaParticionada[2]));
                lineaActual = br.readLine();
            }
          }
          catch(IOException ioe) {
              System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
          }
          return grafo;
    }

    /**
    * Algoritmo para asignar vehiculos compartidos (No tiene en cuenta la restriccion que hay en el problema)
    * Lo que hace es agrupar los duenos de vehiculos en permutaciones de maximo 5 elementos
    * Complejidad: Mejor y Peor Caso O(n), donde n son los duenos de vehiculos y la empresa
    *
    * @param  grafo  Un grafo que puede estar implementado con matrices o con listas de adyacencia
    * @return una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
    */
    public static LinkedList<LinkedList<Integer>> asignarVehiculos(Graph grafo, float p){
          LinkedList<LinkedList<Integer>> carrosDeCarros = new LinkedList<>();
          LinkedList<Float>dist = new LinkedList<>();
          LinkedList<Integer>carro = new LinkedList<>();//LinkedList del carro
          LinkedList<Integer>conductores = new LinkedList<>();
          LinkedList<Integer>nodos = new LinkedList<>();
          for(int i = 1; i < grafo.size; i++){
              float e = distanciaU(grafo,i,p);
              dist.add(e); //LinkedList con la distancia del nodo i hasta la universidad
                              //  System.out.println(dist.size());
          }
          for(int k = 0; k < dist.size(); k++){
              if( grafo.getWeight(0, k) == maxDist(dist,nodos)){
                  nodos.add(k);
                  System.out.println(nodos.size());
                  //dist.remove(k);
              }
          }
          int valorCamino=0;
          System.out.println(nodos.size());
          for(int i = 1; i < nodos.size(); i++){//n
             if (carro.size() == 5){
                 carrosDeCarros.add(carro);
                 valorCamino=0;
                 carro.clear();//Elimina todos los elementos de la lista si el carro ya esta lleno
             } 
             if (conductores.contains(i)){
             } else {
                 carro.add(i);//Agrega el nodo i a la lista del carro
                 ArrayList<Integer>lista = new ArrayList<>();
                 lista = grafo.getSuccessors(i);//ArrayList con los sucesores de i
                 int min = lista.get(0);
                 for(int k = 0; k <= 4; k++){//c
                     for(int j = 0; j < lista.size(); j++){//m
                         if(grafo.getWeight(min, lista.get(j)) < min ){//&& min!=0){
                             min = lista.get(j);//Halla la distancia mas cercana al nodo i
                             System.out.println(min);
                         }
                         if(carro.size() == 5){
                         carrosDeCarros.add(carro);
                         carro.clear();
                     }
                     carro.add(min);//Agrega el mas cercano al nodo en el que se encuentra
                     valorCamino += grafo.getWeight(i, min);
                     conductores.add(min);

                     }
                     //System.out.println(min);
                     carro.add(min);//Agrega el mÃƒÂ¡s cercano al nodo en el que se encuentra
                     conductores.add(min);
                 }
                 
             }
          }
          
          
          /*LinkedList<Integer> permutacion = new LinkedList<Integer>();
          while (dueno <= grafo.size()){
              if (contador == 1){ // Si el contador es 1, crear una nueva permutacion
                  permutacion = new LinkedList<Integer>();
                  permutacion.add(dueno);
                  dueno++; 
                  contador++;
              }
              else { // Sino, seguir insertando en la permutacion actual
                  permutacion.add(dueno);
                  dueno++; 
                  contador++;
                  if (contador == 6 || dueno == grafo.size()){  //Si esto se cumple, agregar la permutacion a la respuesta
                      contador = 1;
                      carrosDeCarros.add(permutacion);
                  }                    
              }
          }
          */
          return carrosDeCarros;
    }
    
    public static int maxDist(LinkedList<Float>List,LinkedList<Integer>nodos){
        float numeromayor;  
        int posicion;
        numeromayor = List.get(0);
        posicion = 0;
        for(int i=0; i<List.size();i++){
            if (List.get(i)>numeromayor && nodos.contains(i)){
                numeromayor = List.get(i);
                posicion = i;
            }
        }
        return (int) numeromayor;
    }
    
    
    public static float distanciaU (Graph grafo, int i, float p){
   
        int x = grafo.getWeight(i, 0);
        float c = x * p;
        return c;
    }
        
    /**
    * Metodo para escribir un archivo con la respuesta
    * Complejidad: Mejor y peor caso es O(n), donde n son los duenos de vehiculo y la empresa
    *
    * @param  permutacionParaCadaSubconjunto es una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
    */
    public static void guardarArchivo(LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto,int numeroDePuntos, float p){
          final String nombreDelArchivo = "respuesta-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
          try {
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
             for (LinkedList<Integer> lista: permutacionParaCadaSubconjunto){
                  for (Integer duenoDeVehiculo: lista)
                       escritor.print(duenoDeVehiculo + " ");
                  escritor.println();
             }             
             escritor.close();
          }
          catch(IOException ioe) {
              System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
          }  
    }
    
    
    public static void main(String[] args){
          //Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por el main
          final int numeroDePuntos = args.length == 0 ? 11 : Integer.parseInt(args[0]);
          final float p = args.length < 2 ? 1.3f : Float.parseFloat(args[1]);
          // Leer el archivo con las distancias entre los duenos de los vehiculos y la empresa
          DigraphAM grafo = leerArchivo(numeroDePuntos, p);
          //int x = grafo.getWeight(1, 0);
          //System.out.println(x);
          /*for(int i = 1; i<=grafo.size; i++){
              int x = grafo.getWeight(i, 0);
              System.out.println(x);
          }*/
          // Asignar los vehiculos compartidos
          long startTime = System.currentTimeMillis();
          LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto = asignarVehiculos(grafo,p);
          long estimatedTime = System.currentTimeMillis() - startTime;
          System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
          System.out.println(permutacionParaCadaSubconjunto.size()+ 15);
          // Guardar en un archivo las abejas con riesgo de colision            
          guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);
   }
 }
