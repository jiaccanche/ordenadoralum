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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.unidad1.clases.Archivos;
import proyecto.unidad1.clases.ClaseRegistro;
import proyecto.unidad1.clases.ordenamientosexterno.MezclaDirectaBigDecimal;
import proyecto.unidad1.clases.ordenamientosexterno.MezclaEquilibradaMultiple;
import proyecto.unidad1.clases.ordenamientosinterno.Burbuja;
import proyecto.unidad1.clases.ordenamientosinterno.Insercion;
import proyecto.unidad1.clases.ordenamientosinterno.Mergesort;
import proyecto.unidad1.clases.ordenamientosinterno.Quicksort;
import proyecto.unidad1.clases.ordenamientosinterno.Shellsort;
import proyecto.unidad1.vista.Registro;
import proyecto.unidad1.vista.TablaReg;

/**
 * Clase que controla la Tabla Registro 
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class ControladorTabla implements ActionListener {
    
    private TablaReg Ventana;
    private Registro registro;
    private JTable TablaCuentas;
    private DefaultTableModel modelo;
    private Archivos Data;
    ArrayList<ClaseRegistro> Lista;
    
    /**
     * Metodo que inicializa la ventana de la Tabla Registro
     * @param v : Objeto que se encarga de inicializar la ventana que contiene la tabla.
     * @param archi : Objeto de la clase Archivo.
     */
    public ControladorTabla (TablaReg v, Archivos archi){
        
        this.Ventana=v;
        this.Data =archi;
        this.Ventana.getAgregarEmp().addActionListener(this);
        this.Ventana.getMenu().addActionListener(this);
        this.TablaCuentas=this.Ventana.getjTable1();
        Lista = this.Data.LeerArchivo("Cuentas.csv");
        MostrarDatosTabla(Lista);
    }

    /**
     * Metodo que se encarga de implementar los eventos de los botones.
     * @param ae : Objeto ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(this.Ventana.getAgregarEmp()==ae.getSource()){
        
        Registro ventana2 = new Registro();
        ControladorRegistro control = new ControladorRegistro(ventana2,this.Data);
        ventana2.setVisible(true);
        this.Ventana.setVisible(false);
        
        
        } //agregar empelado
        
        if (this.Ventana.getMenu()==ae.getSource()) {
            long tiempoInicial = System.currentTimeMillis();
            try {
                int menu = this.Ventana.getMenu().getSelectedIndex();
                
                switch(menu){
                    case 0: //burbuja
                        
                        Burbuja burbuja = new Burbuja();
                        ArrayList<ClaseRegistro> aux = Lista;
                        ReporteTiempo(tiempoInicial);
                        MostrarDatosTabla( burbuja.realizarBurbuja(aux));
                        
                        break;
                    case 1: //insercion
                        
                        Insercion insercion = new Insercion();
                        ArrayList<ClaseRegistro> aux1 = Lista;
                        insercion.realizarInserccion(aux1);
                        ReporteTiempo(tiempoInicial);
                        MostrarDatosTabla(aux1);
                        
                        break;
                    case 2: //mergesort
                        Mergesort mergesort= new Mergesort();
                        ArrayList<ClaseRegistro> aux2 = Lista;
                        mergesort.realizarMergesort(aux2, 0, aux2.size()-1);
                        ReporteTiempo(tiempoInicial);
                        MostrarDatosTabla(aux2);
                        break;
                    case 3: //shelsort
                        Shellsort shell= new Shellsort();
                        ArrayList<ClaseRegistro> aux3 = Lista;
                        shell.realizarshellsort(aux3);
                        ReporteTiempo(tiempoInicial);
                        MostrarDatosTabla(aux3);
                        
                        break;
                    case 4: //quicksort
                        
                        Quicksort quicksort = new Quicksort();
                        ArrayList<ClaseRegistro> aux4 = Lista;
                        quicksort.realizarQuicksort(aux4, 0, aux4.size()-1);
                        ReporteTiempo(tiempoInicial);
                        MostrarDatosTabla(aux4);
                        break;
                        
                    case 5: //Mezcla Directa
                        Archivos archivo = new Archivos();
                        String F0="COPIA.csv";
                        archivo.crearArchivo(F0);
                        archivo.escribirArchivo(F0, Lista);
                        String F1 = "F10.csv";
                        String F2 = "F20.csv";
                        
                        MezclaDirectaBigDecimal mezclad = new MezclaDirectaBigDecimal() ;
                        mezclad.realizarMezclaDirecta(F0, F1, F2);
                        ReporteTiempo(tiempoInicial);
                        ArrayList<ClaseRegistro> aux5 = archivo.LeerArchivo(F0);
                        MostrarDatosImpuestoTabla(aux5);
                        
                        break;
                    case 6: //Mezcla Natural
                        MezclaEquilibradaMultiple mn = new MezclaEquilibradaMultiple();
                        Archivos archivom = new Archivos();
                        String F11 = "COPIAN.csv";
                        archivom.crearArchivo(F11);
                        archivom.escribirArchivo(F11, Lista);
                        String F22 = "F2.csv";
                        String F33 = "F3.csv";
                        String F44 = "F4.csv";

                     mn.realizarMezclaEquilibrada(F11, F22, F33, F44);
                     ReporteTiempo(tiempoInicial);
                     ArrayList<ClaseRegistro> aux6 =archivom.LeerArchivo(F11);
                     
                     MostrarDatosImpuestoTabla(aux6);
                        
                        
                        
                        break;
                        
                }
          } catch (IOException ex) {
                Logger.getLogger(ControladorTabla.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        }
        
       
    }
    
    /**
     * Metodo que muestra los datos con el diseño de Tabla con los parametros de Nombre, Cuenta y Monto:
     * @param Lista : Es la lista que contiene los datos de los empleados con los paramentros de Nombre, Cuenta y Monto.
     */
    public void MostrarDatosTabla(ArrayList<ClaseRegistro> Lista){
    
        String[] titulos={"NOMBRE","CUENTA","MONTO"};
        modelo = new DefaultTableModel(null,titulos);
        
        
        int tam = Lista.size();
        
        String [] datos = new String[5];
        
        for (int i = 0; i < tam; i++) {
            
            datos[0]=Lista.get(i).getNombre();
            datos[1]=Lista.get(i).getCuentaorigen();
            datos[2]=String.valueOf(Lista.get(i).getMonto());
            
            modelo.addRow(datos);
     
               
           }
           
             this.TablaCuentas.setModel(modelo);
            
        }
    
    /**
     * Metodo que muestra los datos con el diseño de Tabla con los parametros de Nombre, Cuenta, Monto e Impuesto
     * @param Lista : Es la lista que contiene los datos de los empleados con los paramentros de Nombre, Cuenta, Monto e Impuesto
     */
    public void MostrarDatosImpuestoTabla(ArrayList<ClaseRegistro> Lista){
    
        String[] titulos={"NOMBRE","CUENTA","MONTO","IMPUESTO"};
        modelo = new DefaultTableModel(null,titulos);
        
        
        int tam = Lista.size();
        BigDecimal DOS = new BigDecimal(0);
        String [] datos = new String[4];
        
        for (int i = 0; i < tam; i++) {
            
            datos[0]=Lista.get(i).getNombre();
            datos[1]=Lista.get(i).getCuentaorigen();
            datos[2]=String.valueOf(Lista.get(i).getMonto());
            datos[3]=String.valueOf(Lista.get(i).getImpuesto().setScale(2, RoundingMode.FLOOR));
            modelo.addRow(datos);
     
               
           }
           
             this.TablaCuentas.setModel(modelo);
            
        }
        
    /**
     * Metodo que realiza la medicion del tiempo en que se realiza el reporte de los empleados con un metodo de ordenamiento.
     * @param t: Tiempo incial cuando empieza a generarse el reporte de los empleados con un metodo de ordenamiento
     */
    public void ReporteTiempo(long t){
        
            long TiempoFinal= System.currentTimeMillis();
            double tiempo = (TiempoFinal-t);
            this.Ventana.getcuadtiempo().setText("Tiempo en realizar el ordenamiento en milisegundos: " + tiempo);
        
        }
       
    }
    

