package arrayList;

import java.sql.*;
import java.util.ArrayList;
import Clases.Movimiento;
import Clases.Producto;
import Conexion.ConexionMySQL;

public class ArrayMovimiento {


    public void registrarMovimiento(String usuario, String accion,String razon, Producto p) {
        String sql = "INSERT INTO movimientos " +
        		     "(usuario, accion, razon, codi_prod, nom_prod, categoria_prod, precio_prod, stock_prod) " +
                     "VALUES (?,?,?,?,?,?,?,?)";
        try (Connection cnx = ConexionMySQL.getConexion();
             PreparedStatement ps = cnx.prepareStatement(sql)) {

        	ps.setString(1, usuario);
            ps.setString(2, accion);
            ps.setString(3, razon);
            ps.setString(4, p.getCodi_prod());
            ps.setString(5, p.getNom_prod());
            ps.setString(6, p.getCategoria_prod());
            ps.setDouble(7, p.getPrecio_prod());
            ps.setInt(8, p.getStock_prod());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR registrarMovimiento: " + e);
        }
    }

    public ArrayList<Movimiento> listarMovimientos() {
        ArrayList<Movimiento> lista = new ArrayList<>();
        String sql = "SELECT id, fecha, usuario, accion, razon, " +
                     "codi_prod, nom_prod, categoria_prod, precio_prod, stock_prod " +
                     "FROM movimientos ORDER BY fecha DESC, id DESC";
        try (Connection cnx = ConexionMySQL.getConexion();
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Movimiento m = new Movimiento(
                        rs.getInt("id"),
                        rs.getString("fecha"),
                        rs.getString("usuario"),
                        rs.getString("accion"),
                        rs.getString("razon"),
                        rs.getString("codi_prod"),
                        rs.getString("nom_prod"),
                        rs.getString("categoria_prod"),
                        rs.getDouble("precio_prod"),
                        rs.getInt("stock_prod")
                );
                lista.add(m);
            }

        } catch (Exception e) {
            System.out.println("ERROR listarMovimientos: " + e);
        }
        return lista;
    }
    public void eliminarMovimiento(int id) {
        String sql = "DELETE FROM movimientos WHERE id = ?";
        try (Connection cnx = ConexionMySQL.getConexion();
             PreparedStatement ps = cnx.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR eliminarMovimiento: " + e);
        }
    }
}
