/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolnario.modelo;

/**
 *
 * @author karju
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private String cargo;
    private String genero ;
    private int edad;
    private int salario;
    private String ident;
    private CiudadEmpleado ciudad;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cargo, String genero, int edad, int salario, String ident, CiudadEmpleado ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.genero = genero;
        this.edad = edad;
        this.salario = salario;
        this.ident = ident;
        this.ciudad = ciudad;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public CiudadEmpleado getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEmpleado ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
    
    
    
    
}
