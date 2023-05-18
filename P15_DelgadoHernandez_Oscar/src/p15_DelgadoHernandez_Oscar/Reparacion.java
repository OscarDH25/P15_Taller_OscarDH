package p15_DelgadoHernandez_Oscar;

import java.text.DecimalFormat;

public abstract class Reparacion extends Trabajo {
	private float precioMaterial;

	public Reparacion(int id, String descripcion) {
		super(id, descripcion);
	}

	public float getPrecioMaterial() {
		return precioMaterial;
	}

	public void setPrecioMaterial(float precioMaterial) {
		this.precioMaterial = precioMaterial;
	}

	@Override
	public float calcularPrecio() {
		return (getHorasTrabajo() * 30) * precioMaterial;
	}

	@Override
	public String cambiarPrecioPiezas(float nuevoPrecio) {
		DecimalFormat f = new DecimalFormat("#.##");
		if (!isTerminado()) {
			setPrecioMaterial(nuevoPrecio);
			return "El nuevo precio de las piezas del trabajo con ID " + getId() + " es: " + f.format(nuevoPrecio)
					+ "€";
		} else
			return "El trabajo con ID " + getId() + " ya esta terminado";

	}

	public String tipoTrabajo() {
		return "";
	}

}
