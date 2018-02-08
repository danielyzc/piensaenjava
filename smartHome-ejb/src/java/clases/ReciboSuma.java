/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class ReciboSuma {
    private short num_mes;
    private BigDecimal cantidad;

    public ReciboSuma(short num_mes, BigDecimal cantidad) {
        this.num_mes = num_mes;
        this.cantidad = cantidad;
    }

    public short getNum_mes() {
        return num_mes;
    }

    public void setNum_mes(short num_mes) {
        this.num_mes = num_mes;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
}
