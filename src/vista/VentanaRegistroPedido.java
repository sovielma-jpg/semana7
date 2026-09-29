package vista;

import modelo.Pedido;
import dao.PedidoDAO;

import javax.swing.*;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtDireccion;
    private JComboBox<String> cmbTipo;
    private JButton btnGuardar;

    public VentanaRegistroPedido() {
        setTitle("Registrar Pedido");
        setSize(300, 200);
        setLayout(null);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 20, 80, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 20, 150, 25);
        add(txtDireccion);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 60, 80, 25);
        add(lblTipo);

        cmbTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});
        cmbTipo.setBounds(100, 60, 150, 25);
        add(cmbTipo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 100, 100, 25);
        add(btnGuardar);

        setLocationRelativeTo(null);
        setVisible(true);

        btnGuardar.addActionListener(e -> {
            Pedido p = new Pedido(0, txtDireccion.getText(), cmbTipo.getSelectedItem().toString(), "PENDIENTE");
            PedidoDAO dao = new PedidoDAO();
            dao.guardar(p);
            JOptionPane.showMessageDialog(this, "Pedido registrado en la base de datos");
            dispose();
        });
    }
}
