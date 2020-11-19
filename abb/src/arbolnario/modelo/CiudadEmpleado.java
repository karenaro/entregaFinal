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
public class CiudadEmpleado {
    
    private String codigo;
    private String nombreC;

    public CiudadEmpleado() {
    }

    public CiudadEmpleado(String codigo, String nombreC) {
        this.codigo = codigo;
        this.nombreC = nombreC;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }
    
    
    
    
    
    
    
}
