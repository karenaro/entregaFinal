/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboln.modelo;

import java.io.Serializable;

/**
 *
 * @author maicol
 */
public class Empleado implements Serializable{
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String cargo;
    private double salario;
    private byte edad;
    private String ident;
    private String genero;

    public Empleado() {
        this.ciudad = new Ciudad();
    }
    
    public Empleado(String nombre, String apellido, String cargo, double salario, byte edad, String identificacion,String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.ciudad = new Ciudad();
        this.salario = salario;
        this.edad = edad;
        this.ident = identificacion;
        this.genero = genero;
    }

    public Empleado(String nombre, String apellido, Ciudad ciudad, String cargo,double salario, byte edad, String identificacion,String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.salario = salario;
        this.edad = edad;
        this.ident = identificacion;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
