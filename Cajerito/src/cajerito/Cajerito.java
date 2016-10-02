package cajerito;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Cajerito extends JFrame {

    int num = 0;
    Usuario user;
    JTextField Texto0, Texto1, Texto2, Texto3;
    JPanel panelPrincipal, panelNumeros, panelOperaciones;

    public Cajerito(Usuario user) {

        super();
        setSize(600, 600);
        setTitle("Cajero Automatico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        this.user = user;

        Pantalla Texto0 = new Pantalla(false, 1);
        this.Texto0 = Texto0.RegresarPantalla();
        this.Texto0.setText("Cuenta de: " + user.getNombre());

        Pantalla Texto1 = new Pantalla(false, 2);
        this.Texto1 = Texto1.RegresarPantalla();
        this.Texto1.setText("Saldo: " + user.getSaldo());

        Pantalla Texto2 = new Pantalla(false, 4);
        this.Texto2 = Texto2.RegresarPantalla();
        this.Texto2.setText("Ingrese el dinero");

        Pantalla Texto3 = new Pantalla(true, 3);
        this.Texto3 = Texto3.RegresarPantalla();
        this.Texto3.setText("0");
        this.Texto3.requestFocusInWindow();

        JPanel panelTextos = new JPanel();
        panelTextos.add(this.Texto0);
        panelTextos.add(this.Texto1);
        panelTextos.add(this.Texto2);
        panelTextos.add(this.Texto3);

        panelOperaciones = new JPanel();
        nuevoBotonOperacion("Depositar");
        nuevoBotonOperacion("Retirar");
        nuevoBotonOperacion("Regresar");

        panelPrincipal.add("Center", panelTextos);
        panelPrincipal.add("South", panelOperaciones);
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        if (btn.getText().equals("Depositar")) {
           
        } else {
           
        }
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        panelOperaciones.add(btn);
    }

    private void operacionPulsado(String tecla) {
        Texto2.setText("Procesando...");
        try {
            num = Integer.parseInt(this.Texto3.getText());
        } catch (Exception e) {
            Texto2.setText("Porfavor ingresa un numero");
        }
        boolean condicion = false;
        switch (tecla) {
            case "Depositar":
                condicion = validar();
                if (condicion && num > this.user.getSaldo()) {
                    user.setSaldo(this.user.getSaldo() + num);
                    Texto1.setText("Saldo: " + this.user.getSaldo());
                    Texto2.setText("Deposito Exitoso");
                } else {
                    Texto2.setText("Ingresa un numero valido");
                }
                Texto3.setText("0");
                break;
            case ("Retirar"):
                if (this.user.getSaldo() >= num) {

                    int Sure;
                    Sure = JOptionPane.YES_NO_OPTION;
                    condicion = validar();
                    if (condicion) {
                        Sure = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas Retirar $" + num + " pesos?", "Confirmacion", Sure);
                        switch (Sure) {
                            case JOptionPane.NO_OPTION:
                                
                                Texto2.setText("Operacion Anulada");
                                break;
                            case JOptionPane.YES_OPTION:
                                user.setSaldo(this.user.getSaldo() - num);
                                Texto2.setText("Retiro Exitoso");
                                
                                Texto2.setText("Operacion Anulada");
                                break;
                            case JOptionPane.CLOSED_OPTION:
                                Texto2.setText("Operacion Anulada");
                                break;
                            default:
                                break;
                        }
                    } else {
                        Texto2.setText("Ingresa un numero valido");
                    }

                    Texto3.setText("0");

                } else {

                    Texto3.setText("0");
                }
                break;
            case "Regresar":
                Menu m = new Menu();
                m.setVisible(true);
                this.dispose();
                break;
            default:
                break;
        }
    }

    private boolean validar() {
        if (num <= 0) {
            num = 0;
            Texto2.setText("Porfavor ingresa un numero valido");
            return false;
        } else {
            return true;
        }
    }
}