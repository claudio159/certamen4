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
@Table (name = "modelo")
public class ModeloModel {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private int idModelo;
    private String nombreModelo;
    private String detalle;
    
    @ManyToOne
    @JoinColumn (name = "id_Marca")
    private MarcaModel MarcaModelo;

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MarcaModel getMarcaModelo() {
        return MarcaModelo;
    }

    public void setMarcaModelo(MarcaModel MarcaModelo) {
        this.MarcaModelo = MarcaModelo;
    }

    public ModeloModel() {
    }

    public ModeloModel(String nombreModelo, String detalle, MarcaModel MarcaModelo) {
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.MarcaModelo = MarcaModelo;
    }

    private ModeloModel(int idModelo, String nombreModelo, String detalle, MarcaModel MarcaModelo) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.MarcaModelo = MarcaModelo;
    }
    
    
}
