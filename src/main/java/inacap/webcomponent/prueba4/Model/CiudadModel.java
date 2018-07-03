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
@Table (name = "ciudad")
public class CiudadModel {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private int idCuidad;
    private String nombreCiudad;
    private String detalle;
    
    @ManyToOne
    @JoinColumn (name = "id_region")
    private RegionModel region;

    public int getIdCuidad() {
        return idCuidad;
    }

    public void setIdCuidad(int idCuidad) {
        this.idCuidad = idCuidad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String detalle, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

    public CiudadModel(int idCuidad, String nombreCiudad, String detalle, RegionModel region) {
        this.idCuidad = idCuidad;
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }
    
    
}
