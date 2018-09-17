/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases.ordenamientosinterno;

import java.util.ArrayList;
import proyecto.unidad1.clases.ClaseRegistro;

/**
 * Clase que realiza el metodo de ordenamiento llamado "Burbuja".
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class Burbuja {
    
    /**
     * Campo de la clase
     * 
     */
    public int movimientos;

    /**
     * Campo de la clase
     */
    public int comparaciones;

    /**
     *
     * @param entrada : Es la lista de las cuentas.
     * @return Retorna las cuentas ordenadas de menor a mayor en su monto.
     */
    public ArrayList<ClaseRegistro> realizarBurbuja(ArrayList<ClaseRegistro> entrada){
        ClaseRegistro temp;
        for (int i = 0; i < entrada.size(); i++) {
            
//            Utilerias.imprimirArreglo(entrada);
            for (int j = 1; j < (entrada.size() - i); j++) {
                comparaciones++;
                //j-1, j
                if (entrada.get(j-1).getMonto()>= entrada.get(j).getMonto()) {
                    
                    temp = entrada.get(j-1);
                    entrada.set(j-1, entrada.get(j));
                    entrada.set(j, temp);
                    
                    movimientos++;
                }
//                Utilerias.imprimirArreglo(entrada);
            }
            }
        return entrada;
    }
   
    
}

