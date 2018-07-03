/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Seba
 */

@Entity
@Table (name = "vehiculo")
public class VehiculoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idVehiculo;
    private String Patente;
    private int Valor;
    private int Año;
    private String Color;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo")
    private TipoVehiculoModel tipoVehiculo; 

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public TipoVehiculoModel getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoModel tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public VehiculoModel() {
    }

    public VehiculoModel(String Patente, int Valor, int Año, String Color, TipoVehiculoModel tipoVehiculo) {
        this.Patente = Patente;
        this.Valor = Valor;
        this.Año = Año;
        this.Color = Color;
        this.tipoVehiculo = tipoVehiculo;
    }

    private VehiculoModel(int idVehiculo, String Patente, int Valor, int Año, String Color, TipoVehiculoModel tipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.Patente = Patente;
        this.Valor = Valor;
        this.Año = Año;
        this.Color = Color;
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    
}
