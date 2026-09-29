package main;

import vista.VentanaRegistroPedido;
import vista.VentanaRegistroRepartidor;
import vista.VentanaListaPedidos;
import vista.VentanaAsignarRepartidor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Configuración inicial de la ventana principal
        JFrame frame = new JFrame("SpeedFast - Menú Principal");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botón para registrar pedido
        JButton btnPedido = new JButton("Registrar Pedido");
        btnPedido.setBounds(100, 30, 200, 30);
        frame.add(btnPedido);

        // Botón para registrar repartidor
        JButton btnRepartidor = new JButton("Registrar Repartidor");
        btnRepartidor.setBounds(100, 80, 200, 30);
        frame.add(btnRepartidor);

        // Botón para listar pedidos
        JButton btnLista = new JButton("Lista de Pedidos");
        btnLista.setBounds(100, 130, 200, 30);
        frame.add(btnLista);

        // Botón para asignar repartidor
        JButton btnAsignar = new JButton("Asignar Repartidor");
        btnAsignar.setBounds(100, 180, 200, 30);
        frame.add(btnAsignar);

        // Acciones de los botones
        btnPedido.addActionListener(e -> new VentanaRegistroPedido());
        btnRepartidor.addActionListener(e -> new VentanaRegistroRepartidor()); // ✅ corregido
        btnLista.addActionListener(e -> new VentanaListaPedidos());
        btnAsignar.addActionListener(e -> new VentanaAsignarRepartidor());     // ✅ correcto

        // Mostrar ventana principal
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
