/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboln.excepcion;

import arboln.modelo.Empleado;

/**
 *
 * @author karju
 */
public class ArbolNExcepction extends Exception{

    public ArbolNExcepction() {
    }
        
    public ArbolNExcepction(String string) {
        super(string);
    }
    
}
