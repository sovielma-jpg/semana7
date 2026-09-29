package dao;

import modelo.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane; // 🔹 Import necesario

public class PedidoDAO {

    public void guardar(Pedido p) {
        String sql = "INSERT INTO pedido(direccion, tipo, estado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getDireccion());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getEstado());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido guardado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar pedido: " + e.getMessage());
        }
    }

    public List<Pedido> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                pedidos.add(new Pedido(
                        rs.getInt("id"),
                        rs.getString("direccion"),
                        rs.getString("tipo"),
                        rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al listar pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    public void actualizarEstado(int idPedido, String nuevoEstado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estado del pedido actualizado a " + nuevoEstado);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar estado: " + e.getMessage());
        }
    }
}
