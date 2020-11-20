/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinarioweb.controlador;

import arbolbinarioweb.controlador.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import arboln.excepcion.ArbolNExcepction;
import arboln.modelo.ArbolN;

import arboln.modelo.Empleado;
import arboln.modelo.NodoN;


/**
 *
 * @author karju
 */
@Named(value = "ArbolNarioControlador")
@SessionScoped
public class ArbolNarioControlador implements Serializable {
    
    private int numero;
    private ArbolN arbolN;
    private DefaultDiagramModel model;  
    private String textoHeader ;
    
    private List<SelectItem> ciudades; 
    private String jefeident;
    private String jefeidentNomina;
    private String jefeidentGenero;
    private String empleadoident;
    private Empleado empleado;
    private Double nomina;
    private int hombres;
    private int mujeres;

    
    /**
     * Creates a new instance of ArbolNarioControlador
     */
    public ArbolNarioControlador() {

    }
    
    @PostConstruct
    private void inicializar()
    {
        empleado = new Empleado();
        arbolN = new ArbolN();
        textoHeader = "Arbol Nario";

        ciudades = new ArrayList<>();
        ciudades.add(new SelectItem(1, "Medellin"));
        ciudades.add(new SelectItem(2, "Filadelfia"));
        ciudades.add(new SelectItem(3, "Supia"));
        ciudades.add(new SelectItem(4, "RioSucio"));
        ciudades.add(new SelectItem(5, "Arauca"));
    }

    /*Metodos de acceso*/
    public String getTextoHeader() {
        return textoHeader;
    }

    public void setTextoHeader(String textoHeader) {
        this.textoHeader = textoHeader;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setCiudades(List<SelectItem> ciudades) {
        this.ciudades = ciudades;
    }
    
    public List<SelectItem> getCiudades() {
        return ciudades;
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getJefeident() {
        return jefeident;
    }

    public void setJefeident(String jefeident) {
        this.jefeident = jefeident;
    }

    public String getEmpleadoident() {
        return empleadoident;
    }

    public String getJefeidentNomina() {
        return jefeidentNomina;
    }

    public void setJefeidentNomina(String jefeidentNomina) {
        this.jefeidentNomina = jefeidentNomina;
    }
    
    public void setEmpleadoident(String empleadoident) {
        this.empleadoident = empleadoident;
    }

    public String getJefeidentGenero() {
        return jefeidentGenero;
    }

    public void setJefeidentGenero(String jefeidentGenero) {
        this.jefeidentGenero = jefeidentGenero;
    }
    
    public Double getNomina() {
        return nomina;
    }

    public void setNomina(Double nomina) {
        this.nomina = nomina;
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
    

    public void agregarEmpleado() {
        try 
        {
            arbolN.agregarNodo(empleado, jefeident);
            JsfUtil.addSuccessMessage("El empleado ha sido adicionado");
            empleado = new Empleado();
            pintarArbol();

        } catch (ArbolNExcepction ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
   
    
    public void nominaEmpleados(){
        arbolN.calcularNominaJefe(jefeidentNomina, arbolN.getRaiz());
        this.nomina = arbolN.getNominaTotal();
        JsfUtil.addSuccessMessage("La nomina del grupo es: " + this.nomina);
        pintarArbol();
    }
    
    public void empleadosGenero(){
        arbolN.calcularGeneroJefe(jefeidentGenero, arbolN.getRaiz());
        this.hombres = arbolN.getHombres();
        this.mujeres = arbolN.getMujeres();
        JsfUtil.addSuccessMessage("Hombres: " + this.hombres + "  Mujeres: " + this.mujeres);
        pintarArbol();
    }
    
    public void pintarArbol() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'#404a4e', lineWidth:8}");
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");
        model.setDefaultConnector(connector);
        pintarArbol(arbolN.getRaiz(), model, null, 25, 0);
    }  

    private void pintarArbol(NodoN reco, DefaultDiagramModel model, Element padre, int x, int y) {

        if (reco != null) {
            Element elementHijo = new Element(reco.getDato().getNombre() + " - " + reco.getDato().getIdent());

            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));
            }

            model.addElement(elementHijo);
            
            int position = 0;
            for (int i = 0; i < reco.getHijos().size(); i++) {
                position = position + 5;
                pintarArbol(reco.getHijos().get(i), model, elementHijo, x - (25 - position), y + 5);
            }
        }
    }

    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
        System.out.println(id.replaceAll("frmArbolNario:diagrama-", ""));
        //Short.valueOf(id.replaceAll("frmMotociclista:diagrama-", ""));
    }
}
