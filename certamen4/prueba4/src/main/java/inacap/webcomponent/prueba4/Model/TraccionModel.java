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
@Table (name = "traccion")
public class TraccionModel {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private int idTraccion;
    private String nombreTraccion;
    private String Detalle;

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public TraccionModel() {
    }

    public TraccionModel(String nombreTraccion, String Detalle) {
        this.nombreTraccion = nombreTraccion;
        this.Detalle = Detalle;
    }

    public TraccionModel(int idTraccion, String nombreTraccion, String Detalle) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.Detalle = Detalle;
    }
    
    
    
    
    
}
