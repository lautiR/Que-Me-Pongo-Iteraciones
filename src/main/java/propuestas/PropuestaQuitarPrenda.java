package propuestas;

import prenda.Prenda;
import usuario.Guardarropas;

public class PropuestaQuitarPrenda implements PropuestaModificacionPrenda{
    private Prenda prenda;

    public PropuestaQuitarPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    @Override
    public void ejecutar(Guardarropas guardarropas) {
        guardarropas.removerPrenda(this.prenda);
    }
}
