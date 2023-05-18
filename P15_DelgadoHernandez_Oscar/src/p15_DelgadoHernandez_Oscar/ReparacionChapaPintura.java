package p15_DelgadoHernandez_Oscar;

public class ReparacionChapaPintura extends Reparacion {
	public ReparacionChapaPintura(int id, String descripcion) {
		super(id, descripcion);
		setPrecioMaterial(1.3f);
	}

	@Override
	public String tipoTrabajo() {
		return "Reparacion de chapa y pintura";
	}
}
