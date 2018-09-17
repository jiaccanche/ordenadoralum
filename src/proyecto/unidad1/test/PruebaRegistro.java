/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.test;

import proyecto.unidad1.clases.Archivos;
import proyecto.unidad1.controlador.ControladorRegistro;
import proyecto.unidad1.controlador.ControladorTabla;
import proyecto.unidad1.vista.Registro;
import proyecto.unidad1.vista.TablaReg;

/**
 * Clase que inicializa el programa 
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class PruebaRegistro {
    
    /**
     * Metodo main que inicializa el programa.
     * @param args
     */
    public static void main(String[] args) {
        Archivos archivo = new Archivos();
        archivo.crearArchivo("Cuentas.csv");
        TablaReg v = new TablaReg();
        ControladorTabla controlador = new ControladorTabla(v,archivo);
        v.setVisible(true);
    }
    
}
