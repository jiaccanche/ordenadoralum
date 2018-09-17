/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyecto.unidad1.clases.Archivos;
import proyecto.unidad1.clases.ClaseRegistro;
import proyecto.unidad1.vista.Registro;
import proyecto.unidad1.vista.TablaReg;

/**
 * Clase que controla la ventana Registro
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class ControladorRegistro implements ActionListener {
    
    private Registro ventana;
    private ClaseRegistro objeto;
    private ArrayList<ClaseRegistro> lista;
    private Archivos ArchivoActual;
    
    /**
     * Metodo que se encarga de inicializar Objetos e inicializar los eventos
     * @param ventana : Objeto que se encarga de inicializar la ventana.
     * @param F : Objeto de la clase Archivo.
     */
    public ControladorRegistro(Registro ventana, Archivos F){
        this.ArchivoActual=F;
        this.ventana=ventana;
        this.ventana.getRegistrar().addActionListener(this);
        lista = this.ArchivoActual.LeerArchivo("Cuentas.csv");
    
    }

    /**
     * Metodo que se encarga de implementar los eventos de los botones.
     * @param ae : Objeto ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(this.ventana.getRegistrar()==ae.getSource()){
            try{
            String nombre = this.ventana.getNom().getText();
            String CuentaD= this.ventana.getCD().getText();
            String CuentaO = this.ventana.getCO().getText();
            int monto=Integer.valueOf(this.ventana.getMon().getText());
            long fecha=System.currentTimeMillis();
            BigDecimal impuesto= CalcularImpuesto(Double.parseDouble(this.ventana.getMon().getText()));
            
           
            
            if (CuentaD.length()==10 && CuentaO.length()==10 && nombre.length()<50 && monto>=10){

                objeto = new ClaseRegistro(nombre,CuentaD,CuentaO,monto,fecha,impuesto);
                lista.add(objeto);
                this.ArchivoActual.escribirArchivo("Cuentas.csv", lista);
                
               TablaReg Ventanita = new TablaReg();
               ControladorTabla Tabla = new ControladorTabla(Ventanita,this.ArchivoActual); 
               
                this.ventana.setVisible(false);
                Ventanita.setVisible(true);

            }
            else{
                throw new IOException();
            }
            
            }
            catch(NumberFormatException ex1){
                JOptionPane.showMessageDialog(null,"Error de formato","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException ex2){
                JOptionPane.showMessageDialog(null,"Error de fomato","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            
        
        }
    }

    private BigDecimal CalcularImpuesto(double monto) {
        
        double porcentaje = .16;
        BigDecimal Impuesto = new BigDecimal(porcentaje*monto);
        
        return Impuesto.setScale(2, RoundingMode.FLOOR);
        
    }
    
    
    
}
