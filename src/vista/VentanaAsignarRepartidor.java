package vista;

import modelo.Pedido;
import modelo.Repartidor;
import modelo.Entrega;
import dao.PedidoDAO;
import dao.RepartidorDAO;
import dao.EntregaDAO;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class VentanaAsignarRepartidor extends JFrame {
    private JComboBox<Pedido> cmbPedidos;
    private JComboBox<Repartidor> cmbRepartidores;
    private JButton btnIniciar;

    public VentanaAsignarRepartidor() {
        setTitle("Asignar Repartidor");
        setSize(400, 250);
        setLayout(null);

        JLabel lblPedido = new JLabel("Pedido:");
        lblPedido.setBounds(20, 20, 80, 25);
        add(lblPedido);

        cmbPedidos = new JComboBox<>();
        cmbPedidos.setBounds(100, 20, 250, 25);
        add(cmbPedidos);

        JLabel lblRepartidor = new JLabel("Repartidor:");
        lblRepartidor.setBounds(20, 60, 80, 25);
        add(lblRepartidor);

        cmbRepartidores = new JComboBox<>();
        cmbRepartidores.setBounds(100, 60, 250, 25);
        add(cmbRepartidores);

        btnIniciar = new JButton("Iniciar Entrega");
        btnIniciar.setBounds(100, 120, 150, 25);
        add(btnIniciar);

        setLocationRelativeTo(null);
        setVisible(true);

        // Cargar datos
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.listarTodos();
        for (Pedido p : pedidos) cmbPedidos.addItem(p);

        RepartidorDAO repartidorDAO = new RepartidorDAO();
        List<Repartidor> repartidores = repartidorDAO.listarTodos();
        for (Repartidor r : repartidores) cmbRepartidores.addItem(r);

        // Acción del botón
        btnIniciar.addActionListener(e -> {
            Pedido pedidoSeleccionado = (Pedido) cmbPedidos.getSelectedItem();
            Repartidor repartidorSeleccionado = (Repartidor) cmbRepartidores.getSelectedItem();

            if (pedidoSeleccionado == null || repartidorSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido y un repartidor");
                return;
            }

            Entrega entrega = new Entrega(
                    0,
                    pedidoSeleccionado.getId(),
                    repartidorSeleccionado.getId(),
                    new Date(System.currentTimeMillis()),
                    new Time(System.currentTimeMillis())
            );

            EntregaDAO entregaDAO = new EntregaDAO();
            entregaDAO.guardar(entrega);

            pedidoDAO.actualizarEstado(pedidoSeleccionado.getId(), "EN_REPARTO");

            JOptionPane.showMessageDialog(this, "Entrega registrada y pedido actualizado a EN_REPARTO");
            dispose();
        });
    }
}
