package proyecto.unidad1.clases.ordenamientosexterno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import proyecto.unidad1.clases.Archivos;
import proyecto.unidad1.clases.ClaseRegistro;

/**
 * Clase que realiza el algoritmo de ordenamiento de Mezcla Equilibrada Multiple con Big Decimal.
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class MezclaEquilibradaMultiple {

    /**
     *
     */
    public final String SALTO = System.lineSeparator();

    /**
     *
     * @param F1 : Nombre del primer archivo llamado "Original" en el cual se ponen los datos a ordenar
     * @param F2: Nombre del segundo archivo llamado "Original" en el cual se realizar la primera particion de los datos
     * @param F3: Nombre del primero archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param F4: Nombre del segundo archivo usado como auxiliar para proceder al ordenamiento de datos
     */
    public void realizarMezclaEquilibrada(String F1, String F2, String F3, String F4) throws IOException {

        boolean band = true;

        particionInicial(F1, F3, F4);

        File archivo1 = new File(F1);
        File archivo2 = new File(F2);
        File archivo3 = new File(F3);
        File archivo4 = new File(F4);

        archivo2.createNewFile();
        archivo4.createNewFile();

        particionFusion(F3, F4, F1, F2);
        band = false;
        do {
            if (band) {


                particionFusion(F3, F4, F1, F2);
                band = false;
            } else {

                particionFusion(F1, F2, F3, F4);
                band = true;
            }
        } while (archivo2.length() > 0l || archivo4.length() > 0);


 }

    /**
     *
     * @param Fs1 : Nombre del primer archivo llamado "Original" en el cual se realiza la segunda fusion de los datos
     * @param Fs2: Nombre del segundo archivo llamado "Original" en el cual se realiza la primera fusion de los datos
     * @param Fs3: Nombre del primero archivo usado como auxiliar para proceder al ordenamiento de datos
     * @param Fs4: Nombre del segundo archivo usado como auxiliar para proceder al ordenamiento de datos
     * @throws FileNotFoundException : Ocurre cuando no el nombre del archivo no se cuentra o
     * cuando el archivo es inaccesible
     */
    public void particionFusion(String Fs1, String Fs2, String Fs3, String Fs4) throws FileNotFoundException, FileNotFoundException, IOException {

         ClaseRegistro r1 = new ClaseRegistro();
        ClaseRegistro r2 = new ClaseRegistro();
        Archivos ar = new Archivos();

        File archivo1 = new File(Fs1);
        File archivo2 = new File(Fs2);
        File archivo3 = new File(Fs3);
        File archivo4 = new File(Fs4);

        FileReader reader1 = new FileReader(archivo1);
        FileReader reader2 = new FileReader(archivo2);
        FileReader reader3 = new FileReader(archivo3);
        FileReader reader4 = new FileReader(archivo4);

        Scanner F1 = new Scanner(reader1);
        Scanner F2 = new Scanner(reader2);

        FileWriter F3 = new FileWriter(archivo3);
        FileWriter F4 = new FileWriter(archivo4);

        boolean ban1 = true;
        boolean ban2 = true;
        boolean ban3 = true;
        
        BigDecimal aux = new BigDecimal(0);
        aux =  BigDecimal.valueOf(Double.MIN_VALUE);

        while ( (F1.hasNextLine() || !ban1) &&  (F2.hasNextLine() || !ban2 ) ) {

            if (ban1) {
                if (F1.hasNextLine()) {
                    String linea = F1.nextLine();
                    r1 = ar.ConvertirObjeto(linea);
                    ban1 = false;
                }
            }

            if (ban2) {
                if (F2.hasNextLine()) {
                    String linea = F2.nextLine();
                    r2 = ar.ConvertirObjeto(linea);
                    ban2 = false;
                }
            }


            if (r1.getImpuesto().compareTo(r2.getImpuesto()) < 0) {
                if (r1.getImpuesto().compareTo(aux) >= 0) {

                    if (ban3) {
                        F3.write(r1.toString() +SALTO);
                    }else {
                        F4.write(r1.toString() + SALTO);
                    }
                    ban1 = true;
                    aux = r1.getImpuesto();

                } else {

                    if (ban3) {
                        F3.write(r2.toString() + SALTO);
                        ban3 = false;
                    } else {
                        F4.write(r2.toString() + SALTO);
                        ban3 = true;
                    }

                    ban2 = true;
                    aux =  BigDecimal.valueOf(Double.MIN_VALUE);
                }
            } else {

                 if (r2.getImpuesto().compareTo(aux) >= 0) {

                    if (ban3) {
                        F3.write(r2.toString() + SALTO);
                    } else {
                        F4.write(r2.toString() + SALTO);
                    }

                    ban2 = true;
                    aux = r2.getImpuesto();

                } else {

                    if (ban3) {
                        F3.write(r1.toString() + SALTO);
                        ban3 = false;
                    } else {
                        F4.write(r1.toString() + SALTO);
                        ban3 = true;
                    }

                    ban1 = true;
                    aux =  BigDecimal.valueOf(Double.MIN_VALUE);
                }

            }

        }

        if (ban1 == false) {

            if (ban3) {
                F3.write(r1.toString() + SALTO);

                while (F1.hasNextLine()) {
                    String linea = F1.nextLine();
                    r1 = ar.ConvertirObjeto(linea);
                    F3.write(r1.toString() + SALTO);
                }

            } else {
                F4.write(r1.toString() + SALTO);


                while (F1.hasNextLine()) {
                    String linea = F1.nextLine();
                    r1 = ar.ConvertirObjeto(linea);
                    F4.write(r1.toString() + SALTO);
                }
            }
        }

        if (ban2 == false) {

            if (ban3) {
                F3.write(r2.toString() + SALTO);

                while (F2.hasNextLine()) {
                    String linea =F2.nextLine(); 
                    r2 = ar.ConvertirObjeto(linea);
                    F3.write(r2.toString() + SALTO);
                }

            } else {
                F4.write(r2.toString() + SALTO);


                while (F2.hasNextLine()) {
                    String linea = F2.nextLine();
                    r2 = ar.ConvertirObjeto(linea);
                    F4.write(r2.toString() + SALTO);
                }
            }

        }


        F3.flush();
        F4.flush();

        F3.close();
        F4.close();
        F1.close();
        F2.close();

    }

    /**
     *
     * @param F1 : Nombre del primer archivo llamado "Original" en el cual se ponen los datos a ordenar
     * @param F3 : Nombre del primer archivo usado como auxiliar en el cual se ponen los datos de la primera particion
     * @param F4 : Nombre del segundo archivo usado como auxiliar en el cual se ponen lso datos de la segunda particion.
     * @throws FileNotFoundException : Ocurre cuando no el nombre del archivo no se cuentra o
     * cuando el archivo es inaccesible
     */
    public void particionInicial(String F1, String F3, String F4) throws FileNotFoundException, IOException {
         
        ClaseRegistro aux = new ClaseRegistro();
        ClaseRegistro r = new ClaseRegistro();
        Archivos ar = new Archivos();
        boolean band = false;

        File archivo1 = new File(F1);
        File archivo3 = new File(F3);
        File archivo4 = new File(F4);

        FileReader reader1 = new FileReader(archivo1);
        Scanner scanner1 = new Scanner(reader1);

        FileWriter writer3 = new FileWriter(archivo3);
        FileWriter writer4 = new FileWriter(archivo4);

        if (scanner1.hasNextLine()) {
            
            String linea = scanner1.nextLine();
            r = ar.ConvertirObjeto(linea);
            writer3.write(r.toString() + SALTO);
            band = true;
            aux = r;
        }

        while (scanner1.hasNextLine()) {
            
            String linea = scanner1.nextLine();
            r = ar.ConvertirObjeto(linea);

            if (r.getImpuesto().compareTo(aux.getImpuesto()) >= 0) {

                aux = r;
                if (band == true) {
                    writer3.write(r.toString() + SALTO);
                }else{
                    writer4.write(r.toString() + SALTO);
                }

            }else{

                aux = r;
                if (band == true) {
                    writer4.write(r.toString() + SALTO);
                    band = false;
                } else {
                    writer3.write(r.toString() + SALTO);
                    band = true;
                }

            }
        }

        scanner1.close();
        writer3.close();
        writer4.close();

    }

    

}