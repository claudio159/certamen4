/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba4.Model;

import java.util.Date;
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
@Table (name = "persona")
public class PersonaModel {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private int idPersona;
    private String Rut;
    private String Nombre;
    private String Apellido;
    private Date fechaNacimiento;
    private String Telefono;
    private String Direccion1;
    private String Direccion2;
    private TipoPersonaModel TipoPersona;
    private CiudadModel Ciudad;

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion1() {
        return Direccion1;
    }

    public void setDireccion1(String Direccion1) {
        this.Direccion1 = Direccion1;
    }

    public String getDireccion2() {
        return Direccion2;
    }

    public void setDireccion2(String Direccion2) {
        this.Direccion2 = Direccion2;
    }

    public TipoPersonaModel getTipoPersona() {
        return TipoPersona;
    }

    public void setTipoPersona(TipoPersonaModel TipoPersona) {
        this.TipoPersona = TipoPersona;
    }

    public CiudadModel getCiudad() {
        return Ciudad;
    }

    public void setCiudad(CiudadModel Ciudad) {
        this.Ciudad = Ciudad;
    }

    public PersonaModel() {
    }

    public PersonaModel(String Rut, String Nombre, String Apellido, Date fechaNacimiento, String Telefono, String Direccion1, String Direccion2, TipoPersonaModel TipoPersona, CiudadModel Ciudad) {
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.Telefono = Telefono;
        this.Direccion1 = Direccion1;
        this.Direccion2 = Direccion2;
        this.TipoPersona = TipoPersona;
        this.Ciudad = Ciudad;
    }

    private PersonaModel(int idPersona, String Rut, String Nombre, String Apellido, Date fechaNacimiento, String Telefono, String Direccion1, String Direccion2, TipoPersonaModel TipoPersona, CiudadModel Ciudad) {
        this.idPersona = idPersona;
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.Telefono = Telefono;
        this.Direccion1 = Direccion1;
        this.Direccion2 = Direccion2;
        this.TipoPersona = TipoPersona;
        this.Ciudad = Ciudad;
    }
    
    
    
    
}
