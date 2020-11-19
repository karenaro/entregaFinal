/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolnario.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karju
 */
public class NodoN {
    
     private Empleado dato;
    private List<NodoN> hijos;

    public NodoN(Empleado dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public Empleado getDato() {
        return dato;
    }

    public void setDato(Empleado dato) {
        this.dato = dato;
    }

    public List<NodoN> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoN> hijos) {
        this.hijos = hijos;
    }
    
     public int obtenerNumeroHijos(){
        return hijos.size();
    }
            
    public void aumentarHijo(NodoN hijo)
    {
        hijos.add(hijo);
    }
    
    
    public Empleado BuscarCiudEmpleados (CiudadEmpleado ciudad){
        int i=-1;
        if (this.hijos.size()>0){
            do{
                i++;
            }while ((i<=this.hijos.size())&&(this.hijos.get(i).dato.getCiudad().equals(ciudad)));
            
        }
        
        if ((i==-1)||(i>=this.hijos.size()))
            return null;
        else 
            return this.hijos.get(i).dato;
      
        
        //falta listar los empleados 
    }// ---fin BuscarCiudad 
    
    
     public Empleado BuscarXGenero (String genero){
        int i=-1;
        if (this.hijos.size()>0){
            do{
                i++;
            }while ((i<=this.hijos.size())&&(this.hijos.get(i).dato.getGenero().equals(genero)));
            
        }
        
        if ((i==-1)||(i>=this.hijos.size()))
            return null;
        else 
            return this.hijos.get(i).dato;
        
        
        //falta imprimir los empleados por genero y cuantos son 
    }// ---fin BuscarGenero 
    
     
     //eliminar todos lo hijos/empleados
     
     public void EliminarTodos(){
         this.hijos.clear();
     }
     
     public NodoN EliminarHijo(int pos){
         return hijos.remove(pos);
     }
}
