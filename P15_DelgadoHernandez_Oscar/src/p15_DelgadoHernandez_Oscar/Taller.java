package p15_DelgadoHernandez_Oscar;

import java.util.ArrayList;

public class Taller {
	private ArrayList<Trabajo> trabajos = new ArrayList<>();

	public Taller() {
	}

	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}

	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

	public int sacarID() {
		return trabajos.size();
	}

	public int numTrabajos() {
		return trabajos.size() - 1;

	}

	public void agregarTrabajo(Trabajo trabajo) {
		trabajos.add(trabajo);
	}

	public Trabajo seleccionarTrabajo(int id) {
		return trabajos.get(id);
	}

}
