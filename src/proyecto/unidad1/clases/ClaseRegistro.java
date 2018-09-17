/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.unidad1.clases;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase que funciona para hacer el registro del empleado con los campos de:
 * Nombre, Cuenta destino, Cuenta origen, monto, fecha de transferencia e impuesto
 * @author jorge canche, luis martinez, eliezer couoh
 */
public class ClaseRegistro {
    
    private String nombre;
    private String  cuentadestino;
    private String cuentaorigen;
    private int monto;
    private long fechatransferencia;
    private BigDecimal impuesto;
    
    /**
     *
     */
    public ClaseRegistro(){}

    /**
     *
     * @param nombre : nombre del empleado.
     * @param cuentadestino : Es la cuenta a la que se le deposita al empleado.
     * @param cuentaorigen : Es la cuenta de la empresa, de la cual se hace el deposito.
     * @param monto : Es la cantidad de dinero que se le deposita al empleado.
     * @param fechatransferencia : Fecha en la que se realizo el movimiento de transferencia.
     * @param impuesto : Es el impuesto que cobra la empresa por el movimiento de transferencia (El 16% del monto total).
     */
    public ClaseRegistro(String nombre, String cuentadestino, String cuentaorigen, int monto, long fechatransferencia, BigDecimal impuesto) {
        this.nombre = nombre;
        this.cuentadestino = cuentadestino;
        this.cuentaorigen = cuentaorigen;
        this.monto = monto;
        this.fechatransferencia = fechatransferencia;
        this.impuesto = impuesto;
    }

    /**
     * Getter
     * @return Metodo que regresa el Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter
     * @param nombre: Metodo que define el Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter
     * @return Metodo que regresa la Cuenta del empleado
     */
    public String getCuentadestino() {
        return cuentadestino;
    }

    /**
     * Setter
     * @param cuentadestino : Es la cuenta a la que se le deposita al empleado.
     */
    public void setCuentadestino(String cuentadestino) {
        this.cuentadestino = cuentadestino;
    }

    /**
     * Getter
     * @return Metodo que regresa la cuenta del empleado.
     */
    public String getCuentaorigen() {
        return cuentaorigen;
    }

    /**
     * Setter
     * @param cuentaorigen : Es la cuenta de la empresa, de la cual se hace el deposito.
     */
    public void setCuentaorigen(String cuentaorigen) {
        this.cuentaorigen = cuentaorigen;
    }

    /**
     * Getter
     * @return Metodo que regresa la cantidad que se le deposito al empleado
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Setter
     * @param monto : Es la cantidad de dinero que se le deposita al empleado.
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Getter
     * @return Metodo que regresa la fecha en que se realizó la transferencia.
     */
    public long getFechatransferencia() {
        return fechatransferencia;
    }

    /**
     * Setter
     * @param fechatransferencia : Fecha en la que se realizo el movimiento de transferencia.
     */
    public void setFechatransferencia(long fechatransferencia) {
        this.fechatransferencia = fechatransferencia;
    }

    /**
     * Getter
     * @return Metodo que regresa el impuesto que se le impondrá a la cantidad que se le dio al empleado.
     */
    public BigDecimal getImpuesto() {
        return impuesto;
    }

    /**
     * Setter
     * @param impuesto : Es el impuesto que cobra la empresa por el movimiento de transferencia (El 16% del monto total).
     */
    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
        
    }

    /**
     * Metodo que realiza la concatenación de los paramentros de la clase.
     * @return Retorna la concatenación en el formato CSV.
     */
    @Override
    public String toString() {
        return  nombre + "," + cuentadestino + "," + cuentaorigen + ","
                + monto + "," + fechatransferencia + "," + impuesto.setScale(2, RoundingMode.FLOOR) ;
    }
    
    
    
    
}
