/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**En esta clase se hace la creación de archivo.
 * la escritura de la informacion
 * de los archivos.
 * la lectura de los archivos y la creacion de String hacia objetos
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class Archivos { 
    /**
     * Campos de la clase
     */
    public final String salto= System.lineSeparator();

    /**
     * Metodo que sirve para crear un archivo
     * @param Nombre : El nombre del archivo que tendra al crearlo.
     */
    public void crearArchivo(String Nombre){
        //creacion del archivo para pasar los datos
        File archivo = new File(Nombre);
        try{
            archivo.createNewFile();
        }
        catch(IOException ex){
            
        }
    }
    
    /**
     * Metodo que escribe la informacion dentro del archivo.
     * @param Nombre : El nombre del archivo para buscarlo y escribir en él.
     * @param Datos : Define cuanta informacion se escribira dentro del archivo
     */
    public void escribirArchivo(String Nombre, ArrayList<ClaseRegistro> Datos){
        //escritura de archivos
        File archivo = new File(Nombre);
        try{
            FileWriter writer = new FileWriter(archivo);
            
            for (int i = 0; i < Datos.size(); i++) {
                String movimiento = Datos.get(i).toString();
                writer.write(movimiento + salto);
                
            }
            writer.close();
        }
        catch(IOException ex){
            
        }
    }
    
    /**
     *
     * Metodo que sirve para leer la informacion del archivo.
     * @param Nombre : El nombre del archivo para buscarlo y leer la información.
     * @return Retorna la informacion de las cuentas con su Nombre, Cuenta de Origen,
     * Cuenta destino, el Monto, la fecha de la transaccion y el impuesto que se le genero.
     */
    public ArrayList<ClaseRegistro> LeerArchivo(String Nombre){
        String cadena;
        ArrayList<ClaseRegistro> Cuentas = new ArrayList<ClaseRegistro>();
        File archivo = new File(Nombre);
        
       try{ FileReader reader = new FileReader(archivo);
       BufferedReader line = new BufferedReader(reader);
       
       while((cadena=line.readLine())!=null){
       
       StringTokenizer tokens=new StringTokenizer(cadena, ",");
               int numDatos1=tokens.countTokens();     //cuenta el numero de particiones que tiene la linea o mes que se desea;
               int i=0;
               String[] Datos1 = new String[numDatos1]; 
               while(tokens.hasMoreTokens()){      
            
                  Datos1[i]=tokens.nextToken();
                  //Aqui introduce la primera particion hasta que llegue a la ultima
                  i++;
                }
               
            String nombre = Datos1[0];
            String CuentaD= Datos1[1];
            String CuentaO = Datos1[2] ;
            int monto=Integer.valueOf(Datos1[3]);
            long fecha= Long.parseLong(Datos1[4]);
            BigDecimal impuesto=  new BigDecimal(Double.parseDouble(Datos1[5]));
            
             ClaseRegistro objeto = new ClaseRegistro(nombre,CuentaD,CuentaO,monto,fecha,impuesto);  
             Cuentas.add(objeto);
       
       }
       
       line.close();
       
       return Cuentas;
        
       }catch(IOException ex){
       
           System.out.println("No hay elementos para devolver");
           return null;
       }
    }

    /**
     * Metodo que convierte una linea o String a un objeto para despues utilizarla
     * en los metodos de ordenamiento
     * @param cadena : Parametro que lee una palabra o string delmitado por comas.
     * @return Retorna El string una vez convertido en un objeto con la informacion
     * del Nombre, Cuenta destino, Cuenta Origen, monto, fecha e impuesto.
     */
    public ClaseRegistro ConvertirObjeto(String cadena){
           
         StringTokenizer tokens=new StringTokenizer(cadena, ",");
               int numDatos1=tokens.countTokens();     //cuenta el numero de particiones que tiene la linea o mes que se desea;
               int i=0;
               String[] Datos1 = new String[numDatos1]; 
               while(tokens.hasMoreTokens()){      
            
                  Datos1[i]=tokens.nextToken();
                  //Aqui introduce la primera particion hasta que llegue a la ultima
                  i++;
                }
               
            String nombre = Datos1[0];
            String CuentaD= Datos1[1];
            String CuentaO = Datos1[2] ;
            int monto=Integer.valueOf(Datos1[3]);
            long fecha= Long.parseLong(Datos1[4]);
            BigDecimal impuesto=  new BigDecimal(Double.parseDouble(Datos1[5]));
            
            ClaseRegistro objeto = new ClaseRegistro(nombre,CuentaD,CuentaO,monto,fecha,impuesto);  
            
            return objeto;
       
       
       
       
    }
    
    
}
