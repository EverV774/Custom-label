/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import java.beans.*;
import java.awt.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author aless
 */

/**
 * Clase para controlar la edición de las propiedades del Label Personalizado en el diseño
 */
public class LabelPersonalizadoEditor extends PropertyEditorSupport{
    private LabelPersonalizado label;
    
    /**
    * Constructor de la clase
    */
    public LabelPersonalizadoEditor() {
    }

    /**
     * Set que stablece el objeto a editar y abre un diálogo personalizado
     * @param bean es el componente que se desea editar
     */
    public void setObject(Object bean) {
        if (bean instanceof LabelPersonalizado) {
            this.label=(LabelPersonalizado)bean;

            Frame parent=null;
            if (SwingUtilities.getWindowAncestor(label) instanceof Frame f) {
                parent = f;
            }

            LabelEditorDialog dialog=new LabelEditorDialog(parent, label);
            dialog.setVisible(true);
        }
    }
}
