/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases.ordenamientosexterno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import proyecto.unidad1.clases.Archivos;
import proyecto.unidad1.clases.ClaseRegistro;

/**
 * Clase que realiza el algoritmo de ordenamiento de Mezcla Directa con Big Decimal.
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class MezclaDirectaBigDecimal{
    
    /**
     * Campo de la clase.
     */
    public final String SALTO = System.lineSeparator();

    /**
     * 
     * Metodo que Realiza el Algoritmo de Mezcla Directa (Particion, Fusion).
     * @param F : Nombre del primer archivo llamado "Original" en el cual se ponen los datos a ordenar
     * @param F1: Nombre del primero archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param F2: Nombre del segundo archivo usado como auxiliar para proceder al ordenamiento de datos
     * 
     */
    public void realizarMezclaDirecta(String F, String F1, String F2) throws IOException {
        int n = tamanoArchivo(F);
        int particion = 1;

        while (particion < n) {
            particionar(F, F1, F2, particion);
            fusionar(F, F1, F2, particion);
            particion = particion * 2;
        }

    }

    /**
     *
     * @param F : Nombre del primer archivo llamado "Original" en el cual se ponen los datos a ordenar
     * @param F1: Nombre del primero archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param F2: Nombre del segundo archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param part : Numero de posicion para particionar los datos
     * @throws FileNotFoundException : Ocurre cuando no el nombre del archivo no se cuenttra o
     * cuando el archivo es inaccesible
     */
    public void particionar(String F, String F1, String F2, int part) throws FileNotFoundException, IOException {

        int k = 0;
        int l = 0;

        File lectura = new File(F);
        File escritura1 = new File(F1);
        File escritura2 = new File(F2);

        FileReader reader = new FileReader(lectura);
        Scanner scanner = new Scanner(reader);

        FileWriter writer1 = new FileWriter(escritura1);
        FileWriter writer2 = new FileWriter(escritura2);

        

        while (scanner.hasNextLine()) {

            k = 0;
            while (k < part) {

                if (scanner.hasNextLine()) {
                    writer1.write(scanner.nextLine()+ SALTO);
                }
                k++;
            }

            l = 0;
            while (l < part) {

                if (scanner.hasNextLine()) {
                    writer2.write(scanner.nextLine() + SALTO);
                }
                l++;
            }

        }

        writer1.close();
        writer2.close();
        scanner.close();
    }

    /**
     *
     * @param F : Nombre del primer archivo llamado "Original" en el cual se ponen los datos a ordenar
     * @param F1: Nombre del primero archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param F2: Nombre del segundo archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param part : Numero de posicion para fusionar los datos
     * @throws FileNotFoundException : Ocurre cuando no el nombre del archivo no se cuenttra o
     * cuando el archivo es inaccesible
     */
    public void fusionar(String F, String F1, String F2, int part) throws FileNotFoundException, IOException {
        Archivos ar = new Archivos();
        ClaseRegistro r1 = new ClaseRegistro();
        ClaseRegistro r2 = new ClaseRegistro();
        int k=0, l=0;
       
        boolean b1 = false, b2 = false;

        File original = new File(F);
        File archivo1 = new File(F1);
        File archivo2 = new File(F2);

        FileReader reader1 = new FileReader(archivo1);
        FileReader reader2 = new FileReader(archivo2);

        Scanner scanner1 = new Scanner(reader1);
        Scanner scanner2 = new Scanner(reader2);

        FileWriter writer = new FileWriter(original);
      String linea;

        if (scanner1.hasNextLine()) {
            
            linea=scanner1.nextLine();
            r1 = ar.ConvertirObjeto(linea);
            
            b1 = true;
        }

        if (scanner2.hasNextLine()) {
             linea=scanner2.nextLine();
            r2 = ar.ConvertirObjeto(linea);
            
            b2 = true;
        }

        while ((scanner1.hasNextLine() || b1) && (scanner2.hasNextLine() || b2)) {

            k = 0;
            l=0;

            while (k < part && b1 && l < part && b2) {
                if (r1.getImpuesto().compareTo(r2.getImpuesto())>=0) {
                    writer.write(r1.toString() + SALTO);
                    k++;
                    b1 = false;
                    if (scanner1.hasNextLine()) {
                         linea=scanner1.nextLine();
                        r1 = ar.ConvertirObjeto(linea);
                        b1 = true;
                    }
                } else {
                    writer.write(r2.toString() + SALTO);
                    l++;
                    b2 = false;
                    if (scanner2.hasNextLine()) {
                         linea=scanner2.nextLine();
                        r2 = ar.ConvertirObjeto(linea);
                        b2 = true;
                    }
                }
            }

            while (k < part && b1) {
                writer.write(r1.toString() + SALTO);
                b1 = false;
                k++;
                if (scanner1.hasNextLine()) {
                     linea=scanner1.nextLine();
                    r1 = ar.ConvertirObjeto(linea);
                    b1 = true;
                }
            }

            while (l < part && b2) {
                writer.write(r2.toString() + SALTO);
                b2 = false;
                l++;
                if (scanner2.hasNextLine()) {
                     linea=scanner2.nextLine();
                    r2 = ar.ConvertirObjeto(linea);
                    b2 = true;
                }
            }

        }

        if (b1) {
            writer.write(r1.toString() + SALTO);
        }

        if (b2) {
            writer.write(r2.toString() + SALTO);
        }

        while (scanner1.hasNextLine()) {
            writer.write(scanner1.nextLine() + SALTO);
        }

        while (scanner2.hasNextLine()) {
            writer.write(scanner2.nextLine() + SALTO);
        }

        scanner1.close();
        scanner2.close();
        writer.close();

    }

    /**
     *
     * @param ruta : La ruta o direccion donde se encuentra el archivo especificado.
     * @return Retorna el tamaño o las lineas que tiene el archivo para poder realizar el algoritmo de ordenamiento
     * @throws FileNotFoundException : Ocurre cuando no el nombre del archivo no se cuenttra o
     * cuando el archivo es inaccesible
     */
    public int tamanoArchivo(String ruta) throws FileNotFoundException, IOException {

        int tamano = 0;

        File archivo = new File(ruta);
        FileReader reader = new FileReader(archivo);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            tamano++;
        }

        scanner.close();
        return tamano;

    }

   
}
