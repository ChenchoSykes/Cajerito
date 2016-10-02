
package cajerito;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Pantalla {
private final JTextField pantalla;
    public Pantalla(boolean b,int a) {
        
        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Colibri", Font.BOLD, 15));
        pantalla.setHorizontalAlignment(JTextField.CENTER);
        pantalla.setEditable(b);
        pantalla.setText("Cajero Automatico");
    }
    
    public JTextField RegresarPantalla(){
        return pantalla;
    }
}

