package main.tienda;

import java.util.ArrayList;

public class Carro {
	private ArrayList <Producto> productos;

	public ArrayList<Producto> getProductos() {
		return productos;
		
	}

	
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	@Deprecated
	public synchronized void delItems(int cantidad, int carro) {
		productos.get(carro).setCantidad( productos.get(carro).getCantidad() - cantidad);
		System.out.println("esto es un Deprecated en TrabajadorPresencial");
	}
	
	
	
	
}
