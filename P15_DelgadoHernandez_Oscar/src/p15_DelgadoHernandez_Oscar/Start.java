package p15_DelgadoHernandez_Oscar;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Start {
	private static Taller europa = new Taller();
	private static DecimalFormat f = new DecimalFormat("#.##");

	private static int pedirInt(int min, int max) {
		Scanner teclado = new Scanner(System.in);
		int num;
		do {
			System.out.println("\nIngrese un valor entre " + min + " y " + max + ": ");
			while (!teclado.hasNextInt()) {
				teclado.next();
				System.out.println("Valor no válido");
			}
			num = teclado.nextInt();
			if (num < min || num > max) {
				System.out.println("Valor fuera de rango");
			}
		} while (num < min || num > max);
		return num;
	}

	private static int pedirIntMinimo(int min) {
		Scanner teclado = new Scanner(System.in);
		int num;
		do {
			System.out.println("\nIngrese un valor mayor o igual a " + min + ": ");
			while (!teclado.hasNextInt()) {
				teclado.next();
				System.out.println("Valor no válido");
			}
			num = teclado.nextInt();
			if (num < min) {
				System.out.println("El valor debe ser mayor o igual a " + min);
			}
		} while (num < min);
		return num;
	}

	private static float pedirFloatPositivo() {
		Scanner teclado = new Scanner(System.in);
		float valor = -1;
		while (valor <= 0) {
			System.out.println("Ingresa un valor positivo mayor que cero:");
			if (teclado.hasNextFloat()) {
				valor = teclado.nextFloat();
			} else {
				teclado.next();
				System.out.println("Valor no válido");
			}
		}
		return valor;
	}

	private static void registrarTrabajo() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduza el tipo de trabajo a registrar:\n1.- Reparacion mecanica\n"
				+ "2.- Reparacion de chapa y pintura\n3.- Revision");
		int tipo = pedirInt(1, 3);
		System.out.println("Introduzca una breve descripcion del trabajo a realizar");
		String descripcion = teclado.nextLine();
		switch (tipo) {
		case 1:
			europa.agregarTrabajo(new ReparacionMecanica(europa.sacarID(), descripcion));
			break;
		case 2:
			europa.agregarTrabajo(new ReparacionChapaPintura(europa.sacarID(), descripcion));
			break;
		case 3:
			europa.agregarTrabajo(new Revision(europa.sacarID(), descripcion));
			break;
		}
		System.out.println("El ID del nuevo trabajo registrado es: " + europa.numTrabajos());
	}

	private static Trabajo pedirTrabajo() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzca el ID del trabajo");
		int id = pedirIntMinimo(0);
		if (id <= europa.numTrabajos())
			return europa.seleccionarTrabajo(id);
		else
			return null;
	}

	private static void trabajoInexistente() {
		System.out.println("El ID introducido no corresponde a ningun trabajo");
	}

	private static void aumentarHoras() {
		Trabajo trabajo = pedirTrabajo();
		if (trabajo != null) {
			System.out.println("Introduzca el numero de horas que quiere añadir al trabajo");
			int horas = pedirInt(1, 99);
			System.out.println(trabajo.aumentarHoras(horas));
		} else
			System.out.println("El ID introducido no corresponde a ningun trabajo");
	}

	private static void aumentarCostePiezas() {
		Scanner teclado = new Scanner(System.in);
		Trabajo trabajo = pedirTrabajo();
		if (trabajo != null) {
			System.out.println("Introduzca el nuevo importe de piezas del trabajo ID " + trabajo.getId());
			float precioNuevo = pedirFloatPositivo();
			System.out.println(trabajo.cambiarPrecioPiezas(precioNuevo));
		} else
			trabajoInexistente();
	}

	private static void finalizarTrabajo() {
		Trabajo trabajo = pedirTrabajo();
		if (trabajo != null) {
			System.out.println(trabajo.finalizarTrabajo());
		} else
			trabajoInexistente();
	}

	private static void mostrarTrabajo() {
		Trabajo trabajo = pedirTrabajo();
		if (trabajo != null) {
			System.out.println("Trabajo ID " + trabajo.getId() + ":\n " + trabajo.tipoTrabajo() + "\n Descripcion: '"
					+ trabajo.getDescripcion() + "'\nPrecio: " + f.format(trabajo.calcularPrecio()) + "€");

		} else
			trabajoInexistente();
	}

	public static void main(String[] args) {
		System.out.println("Bienvenido al taller Europa!!! Ya tenemos supermercados y talleres tambien.");
		int accion = 7;

		while (accion != 0) {
			System.out.println(
					"\nIntroduce la opcion deseada:\n1.- Registrar nuevo trabajo\n2.- Aumentar horas de un trabajo\n"
							+ "3.- Aumentar el coste de las piezas\n4.- Finalizar un trabajo\n5.- Mostrar trabajo\n *Pulsa 0 para salir*");
			accion = pedirInt(0, 5);
			switch (accion) {
			case 1:
				registrarTrabajo();
				break;
			case 2:
				aumentarHoras();
				break;
			case 3:
				aumentarCostePiezas();
				break;
			case 4:
				finalizarTrabajo();
				break;
			case 5:
				mostrarTrabajo();
				break;
			case 0:
				System.out.println("Que tenga un buen dia!!");
				break;
			}
		}
	}
}
