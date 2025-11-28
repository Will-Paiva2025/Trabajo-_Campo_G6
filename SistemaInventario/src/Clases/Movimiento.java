package Clases;

public class Movimiento {

    private int id;
    private String fecha;
    private String usuario;
    private String accion;
    private String razon; 
    private String codiProd;
    private String nomProd;
    private String categoriaProd;
    private double precioProd;
    private int stockProd;
	public Movimiento(int id, String fecha, String usuario, String accion, String razon, String codiProd,
			String nomProd, String categoriaProd, double precioProd, int stockProd) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.accion = accion;
		this.razon = razon;
		this.codiProd = codiProd;
		this.nomProd = nomProd;
		this.categoriaProd = categoriaProd;
		this.precioProd = precioProd;
		this.stockProd = stockProd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getCodiProd() {
		return codiProd;
	}
	public void setCodiProd(String codiProd) {
		this.codiProd = codiProd;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public String getCategoriaProd() {
		return categoriaProd;
	}
	public void setCategoriaProd(String categoriaProd) {
		this.categoriaProd = categoriaProd;
	}
	public double getPrecioProd() {
		return precioProd;
	}
	public void setPrecioProd(double precioProd) {
		this.precioProd = precioProd;
	}
	public int getStockProd() {
		return stockProd;
	}
	public void setStockProd(int stockProd) {
		this.stockProd = stockProd;
	}
	
  
}
