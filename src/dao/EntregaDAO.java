package dao;

import modelo.Entrega;
import java.sql.*;
import javax.swing.JOptionPane;

public class EntregaDAO {

    public void guardar(Entrega entrega) {
        String sql = "INSERT INTO entrega(id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, entrega.getIdPedido());
            ps.setInt(2, entrega.getIdRepartidor());
            ps.setDate(3, entrega.getFecha());
            ps.setTime(4, entrega.getHora());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Entrega registrada correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar entrega: " + e.getMessage());
        }
    }
}
