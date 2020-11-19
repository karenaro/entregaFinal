/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario.modelo;

import arbolbinario.modelo.excepciones.ArbolBinarioException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carloaiza
 */
public class ArbolBinario {

    private Nodo raiz;

    //public void adicionarNodo()
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void isLleno() throws ArbolBinarioException {
        if (raiz == null) {
            throw new ArbolBinarioException("El árbol está vacío");
        }
    }

    public void adicionarNodo(int dato, Nodo ubicacion) throws ArbolBinarioException {
        if (raiz == null) {
            raiz = new Nodo(dato);

        } else {
            if (dato < ubicacion.getDato()) {
                if (ubicacion.getIzquierda() == null) {
                    ubicacion.setIzquierda(new Nodo(dato));
                } else {
                    adicionarNodo(dato, ubicacion.getIzquierda());
                }
            } else if (dato > ubicacion.getDato()) {
                if (ubicacion.getDerecha() == null) {
                    ubicacion.setDerecha(new Nodo(dato));
                } else {
                    adicionarNodo(dato, ubicacion.getDerecha());
                }
            } else {
                throw new ArbolBinarioException("No se puede repetir");
            }  
        }
    }
    
     /**
     * Método que retorna un arreglo de enteros con los datos de recorrer el
     * árbol en postorden
     *
     * @return ArrayList
     * @throws ArbolBinarioException
     */
    public ArrayList postOrden() throws ArbolBinarioException {
        //isLleno();
        ArrayList l = new ArrayList();
        if (raiz != null) {
            postOrden(raiz, l);
        }        
        return l;
    }
    /**
     * Método recursivo que recorre todo el árbol en preorden
     * @param temp Ayudante que toma referencia en un nodo
     * @param listado Acumulador para registrar el dato del nodo visitado
     */
    private void postOrden(Nodo temp, ArrayList listado)
    {
        //Condición que garantiza que el método finalice
        if(temp!=null)
        {           
            postOrden(temp.getIzquierda(), listado);
            postOrden(temp.getDerecha(), listado);
            listado.add(temp.getDato());
        }
    }
    

    /**
     * Método que retorna un arreglo de enteros con los datos de recorrer el
     * árbol en preorden
     *
     * @return ArrayList
     * @throws ArbolBinarioException
     */
    public ArrayList preOrden() throws ArbolBinarioException {
        //isLleno();
        ArrayList l = new ArrayList();
        if (raiz != null) {
            preOrden(raiz, l);
        }        
        return l;
    }
    /**
     * Método recursivo que recorre todo el árbol en preorden
     * @param temp Ayudante que toma referencia en un nodo
     * @param listado Acumulador para registrar el dato del nodo visitado
     */
    private void preOrden(Nodo temp, ArrayList listado)
    {
        //Condición que garantiza que el método finalice
        if(temp!=null)
        {
            listado.add(temp.getDato());
            preOrden(temp.getIzquierda(), listado);
            preOrden(temp.getDerecha(), listado);
        }
    }

    public ArrayList inOrden() throws ArbolBinarioException {
        isLleno();
        ArrayList l = new ArrayList();
        inOrden(raiz, l);
        return l;
    }

    private void inOrden(Nodo reco, ArrayList l) {
        if (reco != null) {
            inOrden(reco.getIzquierda(), l);
            l.add(reco.getDato() + " ");
            inOrden(reco.getDerecha(), l);
        }
    }

    public void llenarArbol(String datos) throws ArbolBinarioException {
        String[] arrayDatos = datos.split(",");
        for (String cadena : arrayDatos) {
            adicionarNodo(Integer.parseInt(cadena), raiz);
        }

    }
    
    
    /**
     * Método que retorna la cantidad de nodos del arbol
     * @return int cantidad de nodos
     */
    public int contarNodos()
    {
        int cont=0;
        if(this.raiz!=null)
        {
          cont=this.contarNodos(raiz, cont);
        }
        return cont;
    }
    
    private int contarNodos(Nodo reco, int cont)
    {
        //Hacen el dllo del contar
        return 67;
    }
    
    /**
     * Método que retorna el numero minimo en un nodos del arbol
     * 
     */
    

    public void menorValor(Nodo reco){
        if( raiz != null){
            while(reco.getIzquierda() != null){
                reco = reco.getIzquierda();
            }
        }
    }
    
    /**
     * Método que retorna el numero mayor en un nodos del arbol
     *  
     */
    public void mayorValor(Nodo reco){
        if( raiz != null){
            while(reco.getDerecha()!= null){
                reco = reco.getDerecha();
            }
        }
    }
    
    /**
     * metodo para buscar un nodo comparandolos uno por uno 
     * @param r
     * @param x
     * @return boolean 
     */
    public boolean buscar(int x) {
        return (buscar(this.raiz, x));


    }
        
    private boolean buscar(Nodo r, int x) {
        if (r == null) {
            return (false);
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzquierda(), x));
        } else if (compara < 0) {
            return (buscar(r.getDerecha(), x));
        } else {
            return (true);
        }
    }
    
    private Nodo buscarMin(Nodo r) {
        for (; r.getIzquierda()!= null; r = r.getIzquierda());
        return (r);
    }
    
    /**
     * Metodo para borrar un Nodo del arbol haciendo un llamado dese el metodo Buscar 
     * @param x
     * @return r valor del nodo 
     */
    public int borrar(int x) {
        if (!this.buscar(x)) {
            return 0;
        }

        Nodo z = borrar(this.raiz, x);
        this.setRaiz(z);
        return x;

    }
    
    private Nodo borrar(Nodo r, int x) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            r.setIzquierda(borrar(r.getIzquierda(), x));
        } else if (compara < 0) {
            r.setDerecha(borrar(r.getDerecha(), x));
        } else {
            System.out.println("Encontro el dato:" + x);
            if (r.getIzquierda()!= null && r.getDerecha()!= null) {
                /*
                 *	Buscar el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                Nodo cambiar = buscarMin(r.getDerecha());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDerecha(borrar(r.getDerecha(), x));
                System.out.println("2 ramas");
            } else {
                r = (r.getIzquierda()!= null) ? r.getIzquierda(): r.getDerecha();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }
    
    public ArrayList imprimirNivel(){
         ArrayList l = new ArrayList();
         if (raiz !=null){
        String[] niveles = new String [raiz.obtenerAlturaNodo() + 1];
        imprimirNivel(raiz, 0, niveles);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + "");            
        }
         }
        return l;
    }
    public void imprimirNivel(Nodo pivote, int nivel2, String[] niveles){
        if (pivote != null){
        niveles[nivel2] = pivote.getDato() +", "+ ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDerecha(), nivel2 + 1, niveles);
            imprimirNivel(pivote.getIzquierda(), nivel2 + 1, niveles);
        
        }
    }
    
     public void podar() {
        podar(this.raiz);
    }

    private void podar(Nodo x) {
        if (x == null) {
            return;
        }
        if ((x.getIzquierda()).isHoja()) {
            x.setIzquierda(null);
        }
        if ((x.getDerecha()).isHoja()) {
            x.setDerecha(null);
        }
        podar(x.getIzquierda());
        podar(x.getDerecha());
    }
    
   public void productoValor(int mult){
       this.producto(this.raiz, mult);
   }
    
    private void producto(Nodo r, int mult){
        if (r!= null){
            producto(r.getIzquierda(),mult);
            r.setDato(r.getDato()*mult);
            producto(r.getDerecha(),mult);
        }
    }
    
        
   
    

}
