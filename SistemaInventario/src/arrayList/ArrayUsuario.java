package arrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Usuario;
import Conexion.ConexionMySQL;

public class ArrayUsuario {
	public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "select id, usuario, clave from usuarios";
        try (Connection cnx = ConexionMySQL.getConexion();
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("clave")
                );
                lista.add(u);
            }
        } catch (Exception e) {
            System.out.println("ERROR listarUsuarios: " + e);
        }
        return lista;
}
	 public void insertar(Usuario u) {
	        String sql = "insert into usuarios(usuario, clave) values(?,?)";
	        try (Connection cnx = ConexionMySQL.getConexion();
	             PreparedStatement ps = cnx.prepareStatement(sql)) {

	            ps.setString(1, u.getUsuario());
	            ps.setString(2, u.getClave());
	            ps.executeUpdate();

	        } catch (Exception e) {
	            System.out.println("ERROR insertar usuario: " + e);
	        }
	    }
	 public void editar(Usuario u) {
	        String sql = "update usuarios set usuario=?, clave=? where id=?";
	        try (Connection cnx = ConexionMySQL.getConexion();
	             PreparedStatement ps = cnx.prepareStatement(sql)) {

	            ps.setString(1, u.getUsuario());
	            ps.setString(2, u.getClave());
	            ps.setInt(3, u.getId());
	            ps.executeUpdate();

	        } catch (Exception e) {
	            System.out.println("ERROR editar usuario: " + e);
	        }
	    }
	 public void eliminar(int id) {
	        String sql = "delete from usuarios where id=?";
	        try (Connection cnx = ConexionMySQL.getConexion();
	             PreparedStatement ps = cnx.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ps.executeUpdate();

	        } catch (Exception e) {
	            System.out.println("ERROR eliminar usuario: " + e);
	        }
	    }
}
