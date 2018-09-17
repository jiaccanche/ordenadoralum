/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases.ordenamientosinterno;

import java.util.ArrayList;
import proyecto.unidad1.clases.ClaseRegistro;



/**
 * Clase que realiza el metodo de ordenamiento llamado "Shellsort".
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class Shellsort {

    /**
     * Campo de la clase
     */
    public int movimientos=0;

    /**
     * Campo de la clase
     */
    public int comparaciones=0;
    
    /**
     * Metodo que realiza el algoritmo de ShellSort con los datos de las cuentas.
     * @param entrada : Es la lista de las cuentas.
     * @return Retorna las cuentas ordenadas de menor a mayor en su monto.
     */
    public ArrayList<ClaseRegistro> realizarshellsort(ArrayList<ClaseRegistro> entrada) {
    
        int n= entrada.size();
        int salto= (int)Math.floor(n/2);
       
        ClaseRegistro temp;
        while(salto>0){
            for (int i = salto; i < n; i++) {
                int j=i;
                temp= entrada.get(i);
                while(j>=salto && entrada.get(j-salto).getMonto()>temp.getMonto()){
                    entrada.set(j, entrada.get(j-salto));
                    
                    j=j-salto;
                    movimientos++;
                }
                entrada.set(j, temp);
                
                
            }
            
            salto= (int)Math.floor(salto/2);
        
        }
        
        
        return entrada;
    }
    
    
    
    
    
    
}
