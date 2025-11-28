package arrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Producto;
import Conexion.ConexionMySQL;

public class ArrayProducto {
	public ArrayList<Producto> ListarProducto(){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		try {
			CallableStatement csta=ConexionMySQL.getConexion().prepareCall("{call sp_Listar()}");
			ResultSet rs=csta.executeQuery();
			Producto produ;
			while (rs.next()) {
				produ=new Producto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
				lista.add(produ);
			}
		} catch (Exception e) {		
		}
		return lista;
	}
	public ArrayList<Producto> ConsultarCod(String cod){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		try {
			Connection cnx=ConexionMySQL.getConexion();
			CallableStatement csta=cnx.prepareCall("{call sp_ConsultarCod(?)}");
			csta.setString(1, cod);
			ResultSet rs=csta.executeQuery();
			Producto produ;
			while(rs.next()) {
				produ=new Producto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4), rs.getInt(5));
				lista.add(produ);
			}
		} catch (Exception e) {
		}
		return lista;
	}
	public ArrayList<Producto> consultarProducto(String nom){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		try {
			java.sql.Statement sta=ConexionMySQL.getConexion().createStatement();
			ResultSet rs=sta.executeQuery("select * from Producto  where nom_prod like '%"+nom+"%'");
			Producto produ;
			while(rs.next()) {
				produ=new Producto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4), rs.getInt(5));
				lista.add(produ);
			}
		} catch (Exception e) {
			
		}
		return lista;
	}
	public void Insertar(Producto produ) {
		try {
			Connection cnx=ConexionMySQL.getConexion();
			CallableStatement csta=cnx.prepareCall("{call sp_Insertar(?,?,?,?,?)}");
			csta.setString(1, produ.getCodi_prod());
			csta.setString(2, produ.getNom_prod());
			csta.setString(3, produ.getCategoria_prod());
			csta.setDouble(4, produ.getPrecio_prod());
			csta.setInt(5, produ.getStock_prod());
			csta.executeUpdate();
			} catch (Exception e) {
			System.out.println("ERROR "+e);
		}
	}
	public void Eliminar(String cod) {
		try {
			Connection cnx=ConexionMySQL.getConexion();
			CallableStatement csta=cnx.prepareCall("{call sp_Eliminar(?)}");
			csta.setString(1, cod);
			csta.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR "+e);
		}
	}
	public void Editar(Producto produ) {
		try {
			Connection cnx=ConexionMySQL.getConexion();
			CallableStatement csta=cnx.prepareCall("{call sp_Editar(?,?,?,?,?)}");
			csta.setString(1, produ.getCodi_prod());
			csta.setString(2, produ.getNom_prod());
			csta.setString(3, produ.getCategoria_prod());
			csta.setDouble(4, produ.getPrecio_prod());
			csta.setInt(5, produ.getStock_prod());
			csta.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR "+e);
		}
}
	public ArrayList<Producto> consultarCategoria(String cat){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		try {
			java.sql.Statement sta=ConexionMySQL.getConexion().createStatement();
			ResultSet rs=sta.executeQuery("select * from Producto where categoria_prod like '%" + cat + "%'");
			Producto produ;
			while(rs.next()) {
				produ=new Producto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4), rs.getInt(5));
				lista.add(produ);
			}
		} catch (Exception e) {
			System.out.println("ERROR consultarCategoria: " + e);
		}
		return lista;
	}
    public ArrayList<String> listarCategorias() {
        ArrayList<String> categorias = new ArrayList<>();
        String sql = "select distinct categoria_prod from Producto order by categoria_prod";
        try (Connection cnx = ConexionMySQL.getConexion();
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("ERROR listarCategorias: " + e);
        }
        return categorias;
    }
    public ArrayList<Producto> listarStockBajo(int minimo) {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "select * from Producto where stock_prod <= ?";
        try (Connection cnx = ConexionMySQL.getConexion();
             PreparedStatement ps = cnx.prepareStatement(sql)) {

            ps.setInt(1, minimo);
            try (ResultSet rs = ps.executeQuery()) {
            	Producto produ;
    			while(rs.next()) {
    				produ=new Producto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4), rs.getInt(5));
    				lista.add(produ);
    			}
                }
            }
         catch (Exception e) {
            System.out.println("ERROR listarStockBajo: " + e);
        }
        return lista;
    }
}
