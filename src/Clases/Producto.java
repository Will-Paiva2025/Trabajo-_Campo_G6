package Clases;

public class Producto {
	private int Codigo;
	private String Producto;
	private Double Precio;
	private int Stock;
	
	public Producto(int codigo, String producto, Double precio, int stock) {
		Codigo = codigo;
		Producto = producto;
		Precio = precio;
		Stock = stock;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getProducto() {
		return Producto;
	}

	public void setProducto(String producto) {
		Producto = producto;
	}

	public Double getPrecio() {
		return Precio;
	}

	public void setPrecio(Double precio) {
		Precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}
	public void DescontrarStock(int cantidad) {
        if (Stock >= cantidad) {
            Stock -= cantidad;
        }
}
}
