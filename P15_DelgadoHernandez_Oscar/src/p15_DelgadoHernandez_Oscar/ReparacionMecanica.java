package p15_DelgadoHernandez_Oscar;

public class ReparacionMecanica extends Reparacion {
	public ReparacionMecanica(int id, String descripcion) {
		super(id, descripcion);
		setPrecioMaterial(1.1f);
	}

	@Override
	public String tipoTrabajo() {
		return "Reparacion mecanica";
	}
}
