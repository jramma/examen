package main.tienda;

public class Producto {
	private String nombre;
	private String marca;
	private double precio;
	private int cantidad;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Producto(String nombre, String marca, double precio, int cantidad) {
		this.marca = marca;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Producto [marca=" + marca + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
				+ "]";
	}
	
	
	
	
}
