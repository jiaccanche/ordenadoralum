/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases.ordenamientosinterno;

import java.util.ArrayList;
import java.util.Random;
import proyecto.unidad1.clases.ClaseRegistro;


/**
 * Clase que realiza el metodo de ordenamiento llamado "Mergesort".
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class Mergesort {
    
    /**
     * Metodo que realiza el algoritmo Diviendo los datos y uniendolos ya acomodados
     * @param arreglo : Arreglo que contiene los datos de los montos de los empleados
     * @param izq : Posicion izquierda del arreglo
     * @param media : Posicion media del arreglo
     * @param der : Posicion derecha del arreglo
     */
    public void merge(ArrayList<ClaseRegistro> arreglo, int izq, int media, int der){
        int n1 = media-izq+1;
        int n2 = der-media;
        
        ArrayList<ClaseRegistro> I = new ArrayList<ClaseRegistro>() ;
        ArrayList<ClaseRegistro> D = new ArrayList<ClaseRegistro>();
        
       // int I[] = new int [n1];
        //int D[] = new int [n2];
        
        for (int i = 0; i < n1; i++) {
            I.add(arreglo.get(izq+i));
            //I[i] = arreglo[izq+i];
        }
        
        for (int j = 0; j < n2; j++) {
            D.add(arreglo.get(media+1+j));
            //D[j] = arreglo[media+1+j];
        }
        
        int i = 0;
        int j = 0;
        
        int k=izq;
        
        while(i < n1 && j < n2){
            if(I.get(i).getMonto()<=D.get(j).getMonto()){
                arreglo.set(k,I.get(i));
                //arreglo[k]=I[i];
                i++;
            }
            else{
                arreglo.set(k,D.get(j));
                //arreglo[k]=D[j];
                j++;
            }
            k++; 
            }
        while(i < n1){
            arreglo.set(k,I.get(i));
            //arreglo[k]= I[i];
            i++;
            k++;
        }
        
        while(j < n2){
            arreglo.set(k,D.get(j));
            //arreglo[k]= D[j];
            j++;
            k++;
        }
        
        
    }
    
    /**
     * Metodo que realiza la union de los datos ya acomodados.
     * @param arreglo : Arreglo que contiene los datos de los montos de los empleados
     * @param izq : Posicion izquierda del arreglo
     * @param der : Posicion derecha del arreglo
     */
    public void realizarMergesort(ArrayList<ClaseRegistro> arreglo, int izq, int der){
        
        
        if(izq<der){
            int media=(izq+der)/2;

            realizarMergesort(arreglo, izq, media);
            realizarMergesort(arreglo, media+1, der);

            merge(arreglo, izq, media, der);  
        }

    }
    
/*    
    public static void main(String[] args) {
        
        Mergesort mergesort= new Mergesort();
        int arreglo[] = mergesort.generarArregloAleatorio(10);
        
        mergesort.imprimirArreglo(arreglo);
       
        mergesort.realizarMergesort(arreglo, 0, arreglo.length-1);
        
        mergesort.imprimirArreglo(arreglo);
    }
  */  
}
