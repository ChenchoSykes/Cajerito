package cajerito;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Menu extends JFrame {
    JPanel panelPrincipal, Botton;

    public Menu() {
        super();
        setSize(600, 600);
        setTitle("Cajero Automatico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        Botton = new JPanel();
        nuevoBotonOperacion("Iniciar Sesion");
        nuevoBotonOperacion("Registrarse");

        panelPrincipal.add("Center", Botton);
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        Botton.add(btn);
    }

    private void operacionPulsado(String tecla) {
        int num = 0;
       if (tecla.equals("Registrarse")) {
           Registro Reg = new Registro();
           Reg.setVisible(true);
           this.dispose();
        }
    }
}
