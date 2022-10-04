package main.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	static Scanner sc = new Scanner(System.in);

	public static byte leerByte(String mensaje) {
		byte input = 0;
		String error = null;
		do {
			error = null;			
			try {
				System.out.println(mensaje);
				input = sc.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Te has equivocado de formato");
				error = e.toString();
			}
			sc.nextLine();
		} while (error != null);
		return input;
	}

	public static int leerInt(String mensaje) {
		int input = 0;
		String error = null;
		do {
			//error = null;
			try {
				System.out.println(mensaje);
				input = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Te has equivocado de formato");
				//error = e.toString();
			}
			sc.nextLine();
		} while (error != null);
		return input;
	}
	
	public static float leerFloat(String mensaje) {
		float input = (float)0;
		String error = null;
		do {
			error = null;			
			try {
				System.out.println(mensaje);
				input = sc.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("Lo has escrito mal, vuelve a introducir un float");
				error = e.toString();
			}
			sc.nextLine();
		} while (error != null);
		return input;
	}
	
		public static Double leerDouble(String mensaje) {
			Double input = (double) 0;
			String error = null;
			do {
				error = null;			
				try {
					System.out.println(mensaje);
					input = sc.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Lo has escrito mal, vuelve a introducir un Double");
					error = e.toString();
				}
				sc.nextLine();
			} while (error != null);
		
		return input;
	}
	
		public static char leerChar(String mensaje) {
			char input = 0;
			String error = null;
			do {
				error = null;			
				try {
					System.out.println(mensaje);
					input = sc.nextLine().charAt(0);
				} catch (Exception e) {
					System.out.println("Lo has escrito mal, vuelve a introducir un char");
					error = e.toString();
				}
				
			} while (error != null);
		
		return input;
	}
	
		public static String leerString(String mensaje) {
			String input = null;
			String error = null;
			do {
				error = null;			
				try {
					System.out.println(mensaje);
					input = sc.nextLine();
				} catch (Exception e) {
					System.out.println("Lo has escrito mal, vuelve a introducir un String");
					error = e.toString();
				}
				
			} while (error != null);
		
		return input;
	}	
		public static boolean leerSiNo(String mensaje) {
			boolean input = false;
			char respuesta = 0;
			String error = null;
			do {
				error= null;
				try {
					System.out.println(mensaje);
					respuesta = sc.nextLine().toLowerCase().charAt(0);
				} catch (Exception e) {
					System.out.println("Lo has escrito mal, vuelve a introducir s o n");
					error = e.toString();
				}
				if(respuesta == 's') {
					input =true;
				}else if(respuesta =='n') {
					input =false;
				}else{
					error = "error";
					System.out.println("La respuesta tiene que ser si o no");
				}
			} while (error != null);
		
		return input;
	}
	
	
	
	
	
}
