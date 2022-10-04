package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.tienda.Carro;
import main.tienda.Producto;
import main.utilities.CarritoVacioException;
import main.utilities.Entrada;

public class Main {

	static ArrayList<Carro> carritos = new ArrayList<Carro>();

	public static void main(String[] args) throws CarritoVacioException, IOException {
		int option = 0;
		int sesion = 0;
		Carro carro;
		int sesionIniciada = 0;
		do {
			sesion = Entrada.leerInt(" 1. Iniciar sesion \n " + "0. Salir \n ");
			if (sesion == 1) {

				carro = new Carro();
				ArrayList<Producto> productos = new ArrayList<Producto>();
				carro.setProductos(productos);
				carritos.add(carro);

				do {
					option = menuText();
					menu(option, sesionIniciada);

				} while (option != 0);
			}

			System.out.println("Cuenta cerrada.");
			sesionIniciada++;
			// faltaría implementar un método que te devuelva a sesiones anteriores
			// este programa no te permite volver a tu sesion
		} while (sesion != 0);
		
	}

	@SuppressWarnings("deprecation")
	private static void menu(int option, int i) throws CarritoVacioException, IOException {
		// el int i es la sesion iniciada
		switch (option) {
		case 1:
			addProducto(i);
			break;
		case 2:
			calcularImporte(i);
			break;
		case 3:
			seeByMarca(i);
			break;
		case 4:
			mostrarProductos(i);
			break;
		case 5:
			if (!(carritos.get(i).getProductos().isEmpty()))
				carritos.get(i).delItems(1, i);

			System.out.println("No tienes primer producto");
			break;
		case 6:
			escribirCsv(i);
		default:
		}

	}

	private static void escribirCsv(int sesion) throws IOException {
		FileWriter csvWriter = null;

		try {
			csvWriter = new FileWriter("new.csv");
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("borra el csv antes de escribir otro");
		}
		if (csvWriter != null) {
			csvWriter.append(String.join(",", "::::::::::: Lista de la compra ::::::::::::"));
			csvWriter.append("\n");

			for (int i = 0; i < carritos.get(sesion).getProductos().size(); i++) {
				String rowData = carritos.get(sesion).getProductos().get(i).toString();
				csvWriter.append(String.join(",", rowData));
				csvWriter.append("\n");
			}

			csvWriter.flush();
			csvWriter.close();
			System.out.println("csv escrito");
		}
	}

	private static void mostrarProductos(int sesion) throws CarritoVacioException {

		try {
			if (carritos.get(sesion).getProductos().isEmpty()) {
				throw new CarritoVacioException("Error: El carro esta vacio");
			} else {
				System.out.println("Carrito:");
				carritos.get(sesion).getProductos().forEach(n -> System.out.println(n));

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {

			System.out.println("-------------------------------------");
		}

	}

	private static void seeByMarca(int sesion) {
		String marca = Entrada.leerString("Indica la marca del producto");
		boolean encontrado = false;
		int i = 0;
		Producto producto = null;
		while (!encontrado && i < carritos.get(sesion).getProductos().size()) {
			if (carritos.get(sesion).getProductos().get(i).getMarca().equalsIgnoreCase(marca)) {
				encontrado = true;
				producto = carritos.get(sesion).getProductos().get(i);
			}
			i++;
		}
		if (producto != null) {

			carritos.get(sesion).getProductos().stream().filter((a) -> a.getMarca().equalsIgnoreCase(marca))
					.forEach((n) -> System.out.println(n));

		} else {
			System.out.println("no tienes productos de esa marca");
		}

	}

	private static void calcularImporte(int sesion) {
		double importe = 0;

		for (int i = 0; i < carritos.get(sesion).getProductos().size(); i++) {
			importe = importe + carritos.get(sesion).getProductos().get(i).getPrecio();

		}
		System.out.println("El importe total es " + importe + " euros.");

	}

	private static void addProducto(int sesion) {
		String nom = Entrada.leerString("Indica el nombre del producto");

		Producto producto = buscarProducto(nom, sesion);
		if (producto != null) {
			producto.setCantidad(
					producto.getCantidad() + Entrada.leerInt("Cuantos más " + producto.getNombre() + " desea añadir?"));
		} else {
			String marca = Entrada.leerString("Introduce la marca");
			double precio = Entrada.leerDouble("Introduce el precio");
			int cantidad = Entrada.leerInt("Cuántos deseas?");

			Producto producto1 = new Producto(nom, marca, precio, cantidad);
			carritos.get(sesion).getProductos().add(producto1);
		}
		System.out.println("añadido correctamente");
	}

	private static Producto buscarProducto(String nom, int sesion) {
		boolean encontrado = false;
		int i = 0;
		Producto producto = null;
		while (!encontrado && i < carritos.get(sesion).getProductos().size()) {
			if (carritos.get(sesion).getProductos().get(i).getNombre().equalsIgnoreCase(nom)) {
				encontrado = true;
				producto = carritos.get(sesion).getProductos().get(i);
			}
			i++;
		}
		return producto;
	}

	private static int menuText() {
		return Entrada.leerInt(" 0. Eixir \n " + "1. Añadir producto al carrito \n " + "2. Calcular importe total \n"
				+ " 3. Mostrar por marca \n " + "4. Mostrar productos (Exception) \n "
				+ "5. Eliminar el primer producto de forma absoleta \n "
				+ "---------------------------------------- \n ");

	}

}
