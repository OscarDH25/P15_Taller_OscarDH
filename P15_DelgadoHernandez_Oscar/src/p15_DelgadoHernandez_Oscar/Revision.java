package p15_DelgadoHernandez_Oscar;

public class Revision extends Trabajo {
	private float precioRevision;

	public Revision(int id, String descripcion) {
		super(id, descripcion);
		precioRevision = 20;
	}

	public float getPrecioRevision() {
		return precioRevision;
	}

	public void setPrecioRevision(float precioRevision) {
		this.precioRevision = precioRevision;
	}

	@Override
	public String cambiarPrecioPiezas(float nuevoPrecio) {
		return "Los trabajos de revision no tienen coste de piezas";
	}

	@Override
	public float calcularPrecio() {
		return (getHorasTrabajo() * 30) + precioRevision;
	}

	@Override
	public String tipoTrabajo() {
		return "Revision";
	}
}
