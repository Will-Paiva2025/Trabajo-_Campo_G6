package Clases;

public class DetalleBoleta {

	    private String codiProd;
	    private String nomProd;
	    private double precio;
	    private int cantidad;
		public DetalleBoleta(String codiProd, String nomProd, double precio, int cantidad) {
			super();
			this.codiProd = codiProd;
			this.nomProd = nomProd;
			this.precio = precio;
			this.cantidad = cantidad;
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
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		 public double getSubtotal() {
		        return precio * cantidad;
		    }
	    
}
