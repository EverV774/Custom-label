/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prueba;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.JLabel;

/**
 *
 * @author aless
 */

/**
 * Clase para crear un componente del tipo Label, personalizado
 */
public class LabelPersonalizado extends JLabel {
    private boolean bold; //Boolean para el estilo Negritas
    private boolean italic; //Boolean para el estilo Cursivas
    private int size; //int para el tamaño del texto
    private Color textColor; // Color para saber el color del texto
    private boolean text; //Boolean para saber si el texto es Mayúsculas o no
    private Color backColor; // Color que indica el color del fondo del Label
    private String font; // String que indica el estilo de letra del texto
    private String borderSt; // String que indica el estilo del borde del Label
    private String alineacion; // String que indica la alineación del texto
    private Timer parpadeoT; // Timer que indica cada cuanto tiempo parpadea el texto
    private boolean parpadeoA; // Boolean que indica si el texto parpadea o no
    private Point click; // Point que ayuda a indicar los eventos del botón izquierdo del mouse
    private boolean movil; // Indica si se puede mover el label en ejecución o no
    
    /**
    * Constructor de la clase para inicializar los valores iniciales de los atributos y algunos eventos
    */
    public LabelPersonalizado(){
        bold=false;
        italic=false;
        size=12;
        textColor=Color.BLACK;
        text=false;
        font="Arial";
        borderSt="NINGUNO";
        alineacion="IZQUIERDA";
        parpadeoA=false;
        parpadeoT=new Timer(500,e->setVisible(!isVisible()));
        movil=false;
        
        addMouseListener(new java.awt.event.MouseAdapter(){
        @Override
        public void mousePressed(java.awt.event.MouseEvent e){
                if(e.getButton()==1&&movil) click=e.getPoint();
            }
        });
        
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)&&movil){
                JComponent comp=(JComponent) e.getSource();
                int thisX=comp.getLocation().x;
                int thisY=comp.getLocation().y;

                int xMoved=e.getX()-click.x;
                int yMoved=e.getY()-click.y;

                int X=thisX+xMoved;
                int Y=thisY+yMoved;

                comp.setLocation(X, Y);
            }
        }
    });
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
    }
    
    /**
    * Set para cambiar el estilo del texto a Negritas
    * @param b indica si la CheckBox esta seleccionada o no
    */
    public void setBold(boolean b){
        bold=b;
        int letra=Font.PLAIN;
        if (bold) letra|=Font.BOLD; //el uso de "|=" ayuda a combinar los estilos de letra
        if (italic) letra|=Font.ITALIC;
        setFont(new Font(font,letra,size));
    }
    
    /**
    * Envía el valor actual del estilo de letra, si esta activo o no
    * @return El valor actual del Boolean bold
    */
    public boolean getBold(){
        return bold;
    }
    
    /**
    * Set para cambiar el estilo del texto a Cursiva
    * @param b indica si la CheckBox esta seleccionada o no
    */
    public void setItalic(boolean b){
        italic=b;
        int letra=Font.PLAIN;
        if (bold) letra|=Font.BOLD; //el uso de "|=" ayuda a combinar los estilos de letra
        if (italic) letra|=Font.ITALIC;
        setFont(new Font(font,letra,size));
    }
    
    /**
    * Envía el valor actual del estilo de letra, si esta activo o no
    * @return El valor actual del Boolean italic
    */
    public boolean getItalic(){
        return italic;
    }
    
    /**
    * Set para cambiar el tamaño actual de la letra sin modificar el resto de propiedades
    * @param i indica si la CheckBox esta seleccionada o no
    */
    public void setFontSize(int i){
        size=i;
        int letra=Font.PLAIN;
        if (bold) letra|=Font.BOLD; //el uso de "|=" ayuda a combinar los estilos de letra
        if (italic) letra|=Font.ITALIC;
        setFont(new Font(font,letra,size));
    }
    
    /**
    * Envía el valor actual del tamaño de la letra
    * @return El valor actual del int size
    */
    public int getFontSize(){
        return size;
    }
    
    /**
    * Set para cambiar el color actual del texto
    * @param c es el Color recibido para el texto
    */
    public void setTextColor(Color c){
        textColor=c;
        setForeground(textColor);
    }
    
    /**
    * Envía el valor actual del color del texto
    * @return El valor actual del Color textColor
    */
    public Color getTextColor(){
        return textColor;
    }
    
    /**
    * Set para cambiar el modo del texto (Mayúscula o minúscula)
    * @param t indica si la CheckBox esta seleccionada o no 
    */
    public void setTextCase(boolean t){
        text=t;
        boolean x=getTextCase();
        if (x==true) {setText(getText().toUpperCase());}
        else {setText(getText().toLowerCase());}
    }
    
    /**
    * Envía el valor actual del modo del texto
    * @return El valor actual del boolean text
    */
    public boolean getTextCase(){
        return text;
    }
    
    /**
    * Set para cambiar el color del fondo del Label
    * @param c es el Color al cual cambiará el fondo 
    */
    public void setBackGroundColor(Color c){
        backColor=c;
        setOpaque(true);
        setBackground(backColor);
    }
    
    /**
    * Envía el valor actual del color del fondo del Label
    * @return El valor actual del Color backColor
    */
    public Color getBackGroundColor(){
        return backColor;
    }
    
    /**
    * Set para cambiar el estilo de letra del texto
    * @param s es el estilo de letra al cual se cambiará el texto 
    */
    public void setFontFamily(String s){
        font=s;
        setFont(new Font(font,getFont().getStyle(),getFont().getSize()));
    }
    
    /**
    * Envía el valor actual del estilo de letra
    * @return El valor actual del String font
    */
    public String getFontFamily(){
        return font;
    }
    
    /**
    * Set para cambiar el estilo del borde del Label
    * @param bs es el estilo del borde al cual se cambiará
    */
    public void setBorderStyle(String bs){
        borderSt=bs;
        switch(borderSt){
            case "NINGUNO" -> setBorder(null);
            case "LINEA" -> setBorder(BorderFactory.createLineBorder(Color.BLACK));
            case "GRUESA" -> setBorder(BorderFactory.createLineBorder(Color.BLACK, 2,true));
            case "PUNTEADA" -> setBorder(BorderFactory.createDashedBorder(Color.BLACK, 5,5));
        }
    }
    
    /**
    * Envía el valor actual del estilo del borde
    * @return El valor actual del String bordeSt
    */
    public String getBorderStyle(){
        return borderSt;
    }
    
    /**
    * Set para cambiar la alineación del texto
    * @param a es la alineación a la cual se cambiará el texto
    */
    public void setAlineacion(String a){
        alineacion=a;
        switch(alineacion){
            case "IZQUIERDA" -> setHorizontalAlignment(SwingConstants.LEFT);
            case "CENTRO" -> setHorizontalAlignment(SwingConstants.CENTER);
            case "DERECHA" -> setHorizontalAlignment(SwingConstants.RIGHT);
        }
    }
    
    /**
    * Envía el valor actual de la alineación del texto
    * @return El valor actual del String alineacion
    */
    public String getAlineacion(){
        return alineacion;
    }
    
    /**
    * Set para que el texto parpadee o no
    * @param activo indica si la CheckBox esta seleccionada o no
    */
    public void setParpadeo(boolean activo){
        parpadeoA=activo;
        if (parpadeoA){
            if (!parpadeoT.isRunning()){
                parpadeoT.start();
            }
        }else{
            if (parpadeoT.isRunning()){
                parpadeoT.stop();
                setVisible(true); // Muestra el Label
            }
        }
    }
    
    /**
    * Envía el estado actual del texto
    * @return El valor actual del boolean parpadeoA
    */
    public boolean getParpadeo(){
        return parpadeoA;
    }
    
    /**
    * Set para que el texto pueda moverse en la ejecución o no
    * @param b indica si la CheckBox esta seleccionada o no
    */
    public void setMovil(boolean b){
        movil=b;
    }
    
    /**
    * Envía el estado actual del texto (si es estático o no)
    * @return El valor actual del boolean movil
    */
    public boolean getMovil(){
        return movil;
    }
    
    /**
    * Método para poder abrir el JDialog del Label al ejecutar con click derecho
    * @param evt representa el evento realizado con el mouse
    */
    private void formMouseClicked (java.awt.event.MouseEvent evt){
        if (evt.getButton()==3) {
            Frame parent=(Frame)SwingUtilities.getWindowAncestor(LabelPersonalizado.this);
            LabelEditorDialog dialogo=new LabelEditorDialog(parent, LabelPersonalizado.this);
            sonidos("/Sonidos/fh_paper_swipe_surface2_short_01wav-14432.wav");
            dialogo.setVisible(true);
        }
    }
    
    /**
    * Método para realizar el sonido indicado al abrir el JDialog del Label con click derecho
    * @param ruta Indica la ruta del sonido .war
    */
    private void sonidos(String ruta){
    try{
        URL sonido=getClass().getResource(ruta);
        if (sonido!=null) {
            AudioInputStream ais=AudioSystem.getAudioInputStream(sonido);
            Clip c=AudioSystem.getClip();
            c.open(ais);
            c.start();
        } else {
            System.err.println("No se encontró el archivo de sonido");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}

