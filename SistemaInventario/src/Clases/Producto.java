package Clases;

public class Producto {
	private String codi_prod;
	private String nom_prod;
	private String categoria_prod;
	private Double precio_prod;
	private int stock_prod;
	public Producto(String codi_prod, String nom_prod, String categoria_prod, Double precio_prod, int stock_prod) {
		super();
		this.codi_prod = codi_prod;
		this.nom_prod = nom_prod;
		this.categoria_prod = categoria_prod;
		this.precio_prod = precio_prod;
		this.stock_prod = stock_prod;
	}
	public String getCodi_prod() {
		return codi_prod;
	}
	public void setCodi_prod(String codi_prod) {
		this.codi_prod = codi_prod;
	}
	public String getNom_prod() {
		return nom_prod;
	}
	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}
	public String getCategoria_prod() {
		return categoria_prod;
	}
	public void setCategoria_prod(String categoria_prod) {
		this.categoria_prod = categoria_prod;
	}
	public Double getPrecio_prod() {
		return precio_prod;
	}
	public void setPrecio_prod(Double precio_prod) {
		this.precio_prod = precio_prod;
	}
	public int getStock_prod() {
		return stock_prod;
	}
	public void setStock_prod(int stock_prod) {
		this.stock_prod = stock_prod;
	}
	
}
