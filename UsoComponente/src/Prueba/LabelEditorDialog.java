/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author aless
 */

/**
 * Clase para crear un JDialog que es asignado al Label Personalizado y modificar sus propiedades en ejecución
 */
public class LabelEditorDialog extends JDialog{
    private LabelPersonalizado label; //Crea nuevo objeto de la clase Label Personalizado
    private JTextField text; // Crea un textField para modificar el texto del label
    private JSpinner size; // Crea un JSpinner para cambiar el tamaño de la letra
    private JCheckBox bold, italic, mayus,parpadeo,movil; // Crea JChechBox para regresar booleanos del estado actual de esa propiedad
    private JComboBox<String> textT, bordeS,alinea; // Crea JComboBox para poder elegir varias opciones específicas de las propiedades
    private JButton textC; //Crea un JButton para abrir el menú de cambiar color del texto
    private JButton fondoC; // Crea un JButton para abrir el menú de colores del fondo del Label
    private JButton bAplicar; //Crea un JButton para aplicar todos los cambios a las propiedades
    
    /**
    * Constructor de la clase para inicializar los valores iniciales de los componentes y agregarlos al JDialog
    * * @param owner indica a que Frame pertenece el JDialog
    * * @param l indica a qué Label Personalizado es asignado
    */
    public LabelEditorDialog(Frame owner, LabelPersonalizado l){
        super (owner,"Personalizar Label",true);
        label=l;
        setLayout(new GridLayout(0, 2, 5, 5));//Permite que los objetos se agreguen en forma de filas y columnas
        text=new JTextField(label.getText());
        size=new JSpinner(new SpinnerNumberModel(label.getFont().getSize(),8,100,1));//mínimo 8, máximo 100, sube de 1 en 1
        bold=new JCheckBox("Negrita",label.getFont().isBold());
        italic=new JCheckBox("Cursiva",label.getFont().isItalic());
        mayus=new JCheckBox ("Todo Mayúsculas",label.getTextCase());
        parpadeo=new JCheckBox ("Parpadear",label.getParpadeo());
        movil=new JCheckBox ("Mover Label",label.getMovil());
        textT= new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());//Muestra todas los tipos de letras dentro de la aplicación
        textT.setSelectedItem(label.getFont().getFamily());
        bordeS=new JComboBox<>(new String[] {"LINEA", "GRUESA", "PUNTEADA", "NINGUNO"}); //Las opciones del combo
        bordeS.setSelectedItem(label.getBorderStyle());
        alinea=new JComboBox<>(new String[] {"IZQUIERDA", "CENTRO", "DERECHA"}); //Las opciones del combo
        alinea.setSelectedItem(label.getAlineacion());
        textC=new JButton ("Color del Texto");
        fondoC=new JButton("Color del fondo");
        bAplicar=new JButton ("Aplicar");
        
        textC.addActionListener(e -> {
            Color c=JColorChooser.showDialog(this,"Elige un color",label.getForeground());//Muestra todos los colores
            if (c!=null) label.setTextColor(c);
        });
        
        fondoC.addActionListener(e -> {
            Color c=JColorChooser.showDialog(this,"Elige un color",label.getForeground());//Muestra todos los colores
            if (c!=null) label.setBackGroundColor(c);
        });
        
        bAplicar.addActionListener(e -> aplica());

        add(new JLabel("Texto:"));
        add(text);
        
        add(new JLabel("Tamaño de letra:"));
        add(size);
        add(bold);
        add(italic);
        add(mayus);
        add(parpadeo);
        add(movil);
        
        add(new JLabel(""));
        add(new JLabel("Tipo de Letra:"));
        add(textT);
        
        add(new JLabel("Alineación del Texto"));
        add(alinea);
        
        add(new JLabel("Color de texto:"));
        add(textC);
        
        add(new JLabel("Estilo del borde"));
        add(bordeS);
        
        add(new JLabel("Color de fondo:"));
        add(fondoC);
        
        add(new JLabel(""));
        add(bAplicar);
        
        pack();
        setLocationRelativeTo(owner);
    }

    /**
    * Método que aplica todos los cambios realizados en el JDialog sobre el Label Personalizado que le fue asignado
    */
    private void aplica(){
        int estilo=Font.PLAIN;
        if (bold.isSelected()) estilo|=Font.BOLD;
        if (italic.isSelected()) estilo|=Font.ITALIC;
        
        label.setText(text.getText());
        label.setFont(new Font((String)textT.getSelectedItem(), estilo, (int)size.getValue()));
        label.setTextCase(mayus.isSelected());
        label.setParpadeo(parpadeo.isSelected());
        label.setMovil(movil.isSelected());
        label.setForeground(label.getTextColor());
        label.setBackGroundColor(label.getBackGroundColor());
        label.setFontFamily((String)textT.getSelectedItem());
        label.setBorderStyle((String)bordeS.getSelectedItem());
        label.setAlineacion((String)alinea.getSelectedItem());
        dispose(); // cerrar el diálogo
    }
}