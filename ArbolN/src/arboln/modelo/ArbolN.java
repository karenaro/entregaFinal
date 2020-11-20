/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboln.modelo;

import java.io.Serializable;
import arboln.excepcion.ArbolNExcepction;

/**
 *
 * @author karju
 */
public class ArbolN implements Serializable{
    
    private NodoN raiz;
    private double nominaTotal = 0;
    private int hombres = 0;
    private int mujeres = 0;
    
    public ArbolN() {
    }

    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }

    public double getNominaTotal() {
        return nominaTotal;
    }

    public void setNominaTotal(double nominaTotal) {
        this.nominaTotal = nominaTotal;
    }

    public int getHombres() {
        return hombres;
    }

    public void setHombres(int hombres) {
        this.hombres = hombres;
    }

    public int getMujeres() {
        return mujeres;
    }

    public void setMujeres(int mujeres) {
        this.mujeres = mujeres;
    }

    public void agregarNodo(Empleado dato, String identificacionPadre) throws ArbolNExcepction {
        
        if(raiz == null) {
            raiz = new NodoN(dato);
        }
        else{
            
            if(buscarNodo(dato.getIdent(), raiz)==null){
            
            NodoN padreEncontrado = buscarNodo(identificacionPadre, raiz);
            if(padreEncontrado!=null){
                padreEncontrado.getHijos().add(new NodoN(dato));
            }else{
                    throw new ArbolNExcepction("Ojo el padre con identificacion '"+ identificacionPadre + "' No existe");
                }
            }else{
                throw new ArbolNExcepction("Ojo el empleado con identificacion '"+ dato.getIdent() + "' No existe");
            }
        }
    }
   
    public NodoN buscarNodo(String identificacion, NodoN ayudnateRaiz) {

        if (ayudnateRaiz.getDato().getIdent().equals(identificacion)) {

            return ayudnateRaiz;
        } else {
            for (NodoN hijo : ayudnateRaiz.getHijos()) {
                NodoN nodoEncontrado = buscarNodo(identificacion, hijo);
                if (nodoEncontrado != null) {
                    return nodoEncontrado;
                }
            }
        }

        return null;
    }
    

    public void calcularNominaJefe(String identificacion, NodoN ayudnateRaiz) {
        this.nominaTotal = 0;
        if (ayudnateRaiz.getDato().getIdent().equals(identificacion)) {

            calcularNomina(ayudnateRaiz);
        } else {
            for (NodoN hijo : ayudnateRaiz.getHijos()) {
                NodoN nodoEncontrado = buscarNodo(identificacion, hijo);
                if (nodoEncontrado != null) {
                    calcularNomina(nodoEncontrado);
                }
            }
        }
    }
    
    private void calcularNomina(NodoN jefe){

        for (NodoN hijo : jefe.getHijos()){
            this.nominaTotal = this.nominaTotal + hijo.getDato().getSalario();
            calcularNomina(hijo);
        }

    }
    

    public void calcularGeneroJefe(String identificacion, NodoN ayudnateRaiz) {
        this.hombres = this.mujeres = 0;
        if (ayudnateRaiz.getDato().getIdent().equals(identificacion)) {

            calcularGenero(ayudnateRaiz);
        } else {
            for (NodoN hijo : ayudnateRaiz.getHijos()) {
                NodoN nodoEncontrado = buscarNodo(identificacion, hijo);
                if (nodoEncontrado != null) {
                    calcularGenero(nodoEncontrado);
                }
            }
        }
    }
    
    private void calcularGenero(NodoN jefe){

        for (NodoN hijo : jefe.getHijos()){
            if(hijo.getDato().getGenero().equals("M")){
                this.hombres = this.hombres + 1;
            }else{
                this.mujeres = this.mujeres + 1;
            }

            calcularGenero(hijo);
        }
    }

}
