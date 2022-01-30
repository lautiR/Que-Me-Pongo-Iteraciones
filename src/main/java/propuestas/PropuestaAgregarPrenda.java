package propuestas;

import prenda.Prenda;
import usuario.Guardarropas;

public class PropuestaAgregarPrenda implements PropuestaModificacionPrenda{
    private Prenda prenda;

    public PropuestaAgregarPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void ejecutar(Guardarropas guardarropas) {
        guardarropas.agregarPrenda(this.prenda);
    }
}
