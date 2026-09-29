package vista;

import modelo.Pedido;
import dao.PedidoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos");
        setSize(600, 400);
        setLayout(null);

        DefaultTableModel modelo = new DefaultTableModel(new String[]{"ID", "Dirección", "Tipo", "Estado"}, 0);
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> pedidos = dao.listarTodos();

        for (Pedido p : pedidos) {
            modelo.addRow(new Object[]{p.getId(), p.getDireccion(), p.getTipo(), p.getEstado()});
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 20, 550, 300);
        add(scroll);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
