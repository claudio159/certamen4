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
import javax.persistence.Table;

/**
 *
 * @author Seba
 */
@Entity
@Table(name="transmision")

public class TransmisionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private int idTransmision;
    private String nombreTransmision;
    private String Detalle;

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public TransmisionModel() {
    }

    public TransmisionModel(String nombreTransmision, String Detalle) {
        this.nombreTransmision = nombreTransmision;
        this.Detalle = Detalle;
    }

    private TransmisionModel(int idTransmision, String nombreTransmision, String Detalle) {
        this.idTransmision = idTransmision;
        this.nombreTransmision = nombreTransmision;
        this.Detalle = Detalle;
    }
    
    
    
}
