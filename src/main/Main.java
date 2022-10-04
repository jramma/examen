package main;

import java.util.ArrayList;

import main.tienda.Producto;
import main.utilities.Entrada;

public class Main {

	static ArrayList<Producto> carrito = new ArrayList<Producto>();

	public static void main(String[] args) {
		int option = 0;

		do {
			option = menuText();
			menu(option);

		} while (option != 0);
		System.out.println("Programa cerrado.");
	}

	private static void menu(int option) {
		switch (option) {
		case 1:
			addProducto();
			break;
		case 2:
			calcularImporte();
			break;
		case 3:
			seeByMarca();
			break;
		default:
		}

	}

	private static void seeByMarca() {
		String marca = Entrada.leerString("Indica la marca del producto");
		boolean encontrado = false;
		int i = 0;
		Producto producto = null;
		while (!encontrado && i < carrito.size()) {
			if (carrito.get(i).getMarca().equalsIgnoreCase(marca)) {
				encontrado = true;
				producto = carrito.get(i);
			}
			i++;
		}
		if (producto != null) {

			carrito.stream().filter((a) -> a.getMarca().equalsIgnoreCase(marca)).forEach((n) -> System.out.println(n));

		} else {
			System.out.println("no tienes productos de esa marca");
		}

	}

	private static void calcularImporte() {
		double importe = 0;

		for (int i = 0; i < carrito.size(); i++) {
			importe = importe + carrito.get(i).getPrecio();

		}
		System.out.println("El importe total es " + importe + " euros.");

	}

	private static void addProducto() {
		String nom = Entrada.leerString("Indica el nombre del producto");

		Producto producto = buscarProducto(nom);
		if (producto != null) {
			producto.setCantidad(
					producto.getCantidad() + Entrada.leerInt("Cuantos más " + producto.getNombre() + " desea añadir?"));
		} else {
			String marca = Entrada.leerString("Introduce la marca");
			double precio = Entrada.leerDouble("Introduce el precio");
			int cantidad = Entrada.leerInt("Cuántos deseas?");

			Producto producto1 = new Producto(nom, marca, precio, cantidad);
			carrito.add(producto1);
		}
		System.out.println("añadido correctamente");
	}

	private static Producto buscarProducto(String nom) {
		boolean encontrado = false;
		int i = 0;
		Producto producto = null;
		while (!encontrado && i < carrito.size()) {
			if (carrito.get(i).getNombre().equalsIgnoreCase(nom)) {
				encontrado = true;
				producto = carrito.get(i);
			}
			i++;
		}
		return producto;
	}

	private static int menuText() {
		return Entrada.leerInt(" 0. Eixir \n " + "1. Añadir producto al carrito \n " + "2. Calcular importe total \n"
				+ " 3. Mostrar por marca \n"
				+ "---------------------------------------- \n ");

	}

}
