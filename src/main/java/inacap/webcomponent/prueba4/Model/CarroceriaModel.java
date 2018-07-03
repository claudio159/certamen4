/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Model;

/**
 *
 * @author Seba
 */
public class CarroceriaModel {
  
    
    private int idCarroceria;
    private String nombreCarroceria;
    private String Detalle;

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String Detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.Detalle = Detalle;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String Detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.Detalle = Detalle;
    }
    
    
}
