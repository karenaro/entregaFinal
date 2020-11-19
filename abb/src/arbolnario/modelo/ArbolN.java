/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolnario.modelo;

import java.util.ArrayList;

/**
 *
 * @author karju
 */
public class ArbolN {
   public NodoN raiz;

    public ArbolN(NodoN raiz) {
        this.raiz = raiz;
    }

    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }
    
       /// Operaciones del arbol
    
public ArrayList<NodoN> retornaHijos(){
        return (ArrayList<NodoN>) this.raiz.getHijos();
    }
    
        
    public boolean esVacio(){
        return (this.raiz==null);
    }
    
    public Empleado retornaDatos (){
        return this.raiz.getDato();
    }
   
    
    
    public NodoN buscarNodo(String ident, NodoN ayudante){
         if (ayudante.getDato().getIdent()==ident){
            return ayudante;
        } else {
            //recorrer hijos 
            for(NodoN hijo: ayudante.getHijos()){
                NodoN nodoEncontrado= buscarNodo(ident, hijo);
                if(nodoEncontrado!=null){
                    return nodoEncontrado;
                }
            }
        }
        return null;
    }
   

public void adicionarNodo(Empleado dato, String identificacionPadre, NodoN ayudante){
   
    
    if (raiz==null){
        
        raiz= new NodoN(dato);
        
    }else{
        if(buscarNodo(dato.getIdent(), raiz)==null){
            
            NodoN padreEncontrado = buscarNodo(identificacionPadre, raiz);
            if(padreEncontrado!=null){
                padreEncontrado.getHijos().add(new NodoN(dato));
            }else{
                System.out.println("Ojo el padre con identificacion" + identificacionPadre + "No Existe");
            }
        }else{
             System.out.println("Ojo el Empleado con identificacion" + dato.getIdent() + "No Existe");
        }
    }
}    
        



    
    
}
