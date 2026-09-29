package vista;

import modelo.Repartidor;
import dao.RepartidorDAO;

import javax.swing.*;

public class VentanaRegistroRepartidor extends JFrame {
    private JTextField txtNombre;
    private JButton btnGuardar;

    public VentanaRegistroRepartidor() {
        setTitle("Registrar Repartidor");
        setSize(400, 200);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 250, 25);
        add(txtNombre);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 60, 150, 25);
        add(btnGuardar);

        setLocationRelativeTo(null);
        setVisible(true);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre");
                return;
            }

            Repartidor r = new Repartidor(0, nombre);
            RepartidorDAO dao = new RepartidorDAO();
            dao.guardar(r);
            JOptionPane.showMessageDialog(this, "Repartidor registrado correctamente");
            dispose();
        });
    }
}
