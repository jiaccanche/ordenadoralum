/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases.ordenamientosinterno;

import java.util.ArrayList;
import proyecto.unidad1.clases.ClaseRegistro;

/**
 * Clase que realiza el metodo de ordenamiento llamado "Quicksort".
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class Quicksort {
    
    /**
     * Metodo que realiza la particion del arreglo en el cual estan los datos de registro de los empleados.
     * @param arreglo : Arreglo que contiene los datos de los montos de los empleados
     * @param izq : Posicion izquierda del arreglo
     * @param der : Posicion media del arreglo
     * @return Retorna los datos ya particionados.
     */
    public int partir(ArrayList<ClaseRegistro> arreglo,int izq, int der){
    
        int pivote = arreglo.get(der).getMonto();
        
        int cIntercambios = izq; 
        
        
        for (int cPosiciones = izq; cPosiciones < der; cPosiciones++) {
            
            if (pivote >= arreglo.get(cPosiciones).getMonto()) {
                
                ClaseRegistro temp = arreglo.get(cIntercambios);
                arreglo.set(cIntercambios, arreglo.get(cPosiciones));
                arreglo.set(cPosiciones,temp);
               
                cIntercambios++;
            }
            
        }
        
        
        ClaseRegistro temp = arreglo.get(cIntercambios);
        arreglo.set(cIntercambios, arreglo.get(der));
        arreglo.set(der,temp);
        return cIntercambios;
        
    }
    
    /**
     * Metodo que realiza el ordenamiento del arreglo con el ordenamiento "QuickSort"
     * @param arreglo : Arreglo que contiene los datos de los montos de los empleados
     * @param izq : Posicion izquierda del arreglo
     * @param der : Posicion media del arreglo
     */
    public void realizarQuicksort(ArrayList<ClaseRegistro> arreglo, int izq, int der){
    
        if(izq<der){
        int pivote = partir(arreglo,izq,der);
    
        realizarQuicksort(arreglo, izq, pivote-1);
        realizarQuicksort(arreglo, pivote+1,der);
        
    }    
    
    
    }
    
    
}
