/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import java.beans.*;
import java.beans.BeanDescriptor;

/**
 *
 * @author aless
 */

/**
 * Clase para modificar las Propiedades y Descripciones de la información Bean del Label Personalizado
 */
public class LabelPersonalizadoBeanInfo extends SimpleBeanInfo{
    
    /**
    * Get creado para recibir el valor del BeanDescriptor actual y modificar el del Label Personalizado
    @return El nuevo BeanDescriptor para el Label Personalizado
    */
    @Override //Indica que se modifica el método getBeanDescriptor Original
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor descriptor=new BeanDescriptor(LabelPersonalizado.class);
        descriptor.setValue("Modificar...",LabelPersonalizadoEditor.class); 
        return descriptor;
    }
    
    /**
    * Método creado para crear las Descripciones de las Propiedades (sets y gets) del Label Personalizado, además de modificar sus nombres en Propiedades
    @return Un arreglo que incluye todos los cambios de las Descripciones de las Propiedades del Label Personalizado
    */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor text=new PropertyDescriptor("text", LabelPersonalizado.class);
            text.setDisplayName("Modificar Texto");

            PropertyDescriptor fontSize=new PropertyDescriptor("fontSize", LabelPersonalizado.class);
            fontSize.setDisplayName("Tamaño de letra");

            PropertyDescriptor bold=new PropertyDescriptor("bold", LabelPersonalizado.class);
            bold.setDisplayName("Negritas");

            PropertyDescriptor italic=new PropertyDescriptor("italic", LabelPersonalizado.class); 
            italic.setDisplayName("Cursivas");

            PropertyDescriptor textColor=new PropertyDescriptor("textColor", LabelPersonalizado.class); 
            textColor.setDisplayName("Color del Texto");

            PropertyDescriptor backColor=new PropertyDescriptor("backGroundColor", LabelPersonalizado.class); 
            backColor.setDisplayName("Color del Fondo");

            PropertyDescriptor textCase=new PropertyDescriptor("textCase", LabelPersonalizado.class); 
            textCase.setDisplayName("Todo Mayúsculas");

            PropertyDescriptor fontFamily=new PropertyDescriptor("fontFamily", LabelPersonalizado.class); 
            fontFamily.setDisplayName("Tipo de Letra");

            PropertyDescriptor borderStyle=new PropertyDescriptor("borderStyle", LabelPersonalizado.class); 
            borderStyle.setDisplayName("Estilo de Borde");
            
            PropertyDescriptor alineacion=new PropertyDescriptor("alineacion", LabelPersonalizado.class); 
            alineacion.setDisplayName("Alineación del Texto");
            
            //Aqui no se agrego el parpadeo ya que solo funciona al ejecutar, en edición confunde a NetBeans
            //Tampoco si el label se puede mover, ya que en edición ya se mueve
            
            return new PropertyDescriptor[] {
                text, fontSize, bold, italic, textColor,
                backColor, textCase, fontFamily, borderStyle,
                alineacion
            };

        } catch (IntrospectionException e) {
            e.printStackTrace();
            return null;
        }
    }
}

