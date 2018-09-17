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
 * Clase que realiza el metodo de ordenamiento llamado "Insercion".
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class Insercion {
    
    /**
     * Metodo que realiza el algoritmo de Inserccion con los datos de las cuentas.
     * @param entrada : Es la lista de las cuentas.
     * @return Retorna las cuentas ordenadas de menor a mayor en su monto.
     */
    public ArrayList<ClaseRegistro>  realizarInserccion(ArrayList<ClaseRegistro> entrada){
        ClaseRegistro temporal;
        for (int i = 1; i < entrada.size(); i++) {
           int j = i;
           while(j>0 && comparar( entrada.get(j).getMonto(), entrada.get(j-1).getMonto())){
                temporal = entrada.get(j);
                entrada.set(j, entrada.get(j-1));
                entrada.set(j-1, temporal);
               j--;
           }
       }
        return entrada;
    }
    
    /**
     * Campo de la clase
     */
    public int comparaciones;
    
    /**
     * Metodo que realiza la comparacion de que valor es mayor
     * @param valor1 : Valor entero 1
     * @param valor2 : Valor entero 2
     * @return Retorna true si valor 1 es igual o menor que valor 2 de lo contrario false
     */
    public boolean comparar (int valor1, int valor2){
        comparaciones++;
        return valor1 <= valor2;
    }
    

}
