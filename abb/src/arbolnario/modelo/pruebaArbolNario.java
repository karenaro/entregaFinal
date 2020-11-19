/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolnario.modelo;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author karju
 */
public class pruebaArbolNario {
    
     public static void main(String[] args) {
         
         
         int opc =0;
         
          do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1. Adicionar Empleado \n "
                                                                       +"2. Buscar Empleado\n"
                                                                       +"3. Cabiar Empleado De Ciudad \n "
                                                                       + "4. Cant de Empleado X Genero"
                                                                       + "5. Empleados Por Ciudad"
                                                                       + "6. Siguiente "
                                                                       +"Selecciones una opcion"));
                switch(opc){
                    case 1:               
                        break;
                     
                    case 2:
                        break;
                           
                    case 3:                 
                        break;
                        
                     case 4:               
                        break;
                        
                     case 5:                
                        break;
                    
                    case 6:
                        JOptionPane.showMessageDialog(null, "Siguiente", " Abriendo Proxima ventana 3 ", JOptionPane.INFORMATION_MESSAGE);
                        break;
                        
                }
            }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null,"Error"+n.getMessage());
            }
        }while(opc!=6);//FIN DEL MENU
         
        
          int opc =0;
         
          do{
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1. Depedir Empleado \n "
                                                                       +"2. Ascender Empleado\n"
                                                                       +"3. Promedio de Edad x Genero \n "
                                                                       + "4. Salir"
                                                                       +"Selecciones una opcion"));
                switch(opc){
                    case 1:               
                        break;
                     
                    case 2:
                        break;
                        
                    case 3:                 
                        break;
                        
                     case 4:
                        a = false;
                     
                         break;
                    
            default: 
                   
                JOptionPane.showMessageDialog(null, "Opción no válida ");
               
                break;
        
     
     }
     
    
}
