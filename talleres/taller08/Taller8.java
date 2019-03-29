/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago_Albisser
 */
public class Taller8 {
    public static int[] mergesort(int[]a) {
    mergesort(a, 0, a.length-1);
    return a;
  }
  private static void mergesort(int[]j,int x, int a) {
    if(x < a) {
      int m = (x+a)/2;
      mergesort(j,x,m);
      mergesort(j,m+1,a);
      merge(j,x,m,a);
    }
  }
  private static void merge(int[]p,int x, int n, int z) {
    int temp1 = (n-x)+1;
    int temp2 = z-n;
    int[] arrL = new int[temp1];
    int[] arrR = new int[temp2];
    for(int i=0;i<temp1;i++){
      arrL[i]= p[x+i];
    }
    for(int j=0;j<temp2;j++){
      arrR[j]= p[n+j+1];
    }
    int i = 0;
    int j = 0;
    int k = x;
    while(i<temp1 && j<temp2){
      if(arrL[i] <= arrR[j]){
        p[k] = arrL[i];
        i++;
      }else{
        p[k] = arrR[j];
        j++;
      }
      k++;
    }
    while(i < temp1){
      p[k] = arrL[i];
      i++;
      k++;
    }
    while(j < temp2){
      p[k] = arrR[j];
      j++;
      k++;
    }
  }
  public static int[] quicksort(int[] arr) {
    quicksort(arr, 0, arr.length - 1);
    return arr;
  }
  private static void quicksort(int[] arr, int l, int r) {
    if(l < r) {
      int p = partition(arr, l, r);
      quicksort(arr, l, p-1);
      quicksort(arr, p+1, r);
    }
  }
  private static int partition(int[] arr, int l, int r) {
    int pivot = arr[r];
    int i = (l-1);
    for(int j = l; j <= r - 1; j++) {
      if(arr[j] <= pivot) {
        i++; 
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      } 
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[r];
    arr[r] = temp;
    return (i + 1);
  }
  public static void main(String[] args) {
    int[] a = {9,3,5,4};
    int[] b = quicksort(a);
    for(int v : b) {
      System.out.println(v);
    }
  }
}
