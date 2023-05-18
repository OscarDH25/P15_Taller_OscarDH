package p15_DelgadoHernandez_Oscar;

public abstract class Trabajo {
	private int id;
	private int horasTrabajo;
	private boolean terminado;
	private String descripcion;

	public Trabajo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
		horasTrabajo = 0;
		terminado = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorasTrabajo() {
		return horasTrabajo;
	}

	public void setHorasTrabajo(int horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float calcularPrecio() {
		return 0;
	}

	public String finalizarTrabajo() {
		if (!terminado) {
			terminado = true;
			return "Terminado el trabajo con id " + id + "!!! (" + descripcion + ")";
		} else {
			return "El trabajo con ID " + id + " ya estaba terminado";
		}
	}

	public String aumentarHoras(int horas) {
		if (!terminado) {
			horasTrabajo += horas;
			return "El trabajo ya lleva " + horasTrabajo + " horas invertidas";
		} else {
			return "El trabajo con ID " + id + " ya esta terminado";
		}
	}

	public String cambiarPrecioPiezas(float nuevoPrecio) {
		return "";
	}

	public String tipoTrabajo() {
		return "";
	}

}
