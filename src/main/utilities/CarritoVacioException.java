package main.utilities;

public class CarritoVacioException extends Exception{

	private static final long serialVersionUID = 1L;

	public CarritoVacioException(String mensaje) {
		super(mensaje);
	}
}
