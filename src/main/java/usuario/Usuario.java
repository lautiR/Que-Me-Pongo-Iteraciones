package usuario;

import prenda.Atuendo;
import usuario.Guardarropas;

import java.util.List;

public class Usuario {
    private List<Guardarropas> guardarropas;
    private Guardarropas guardarropasSeleccionado;

    public Usuario(List<Guardarropas> guardarropas) {
        this.guardarropas = guardarropas;
    }
    public Atuendo sugerirAtuendo() {
        return this.guardarropasSeleccionado.sugerirAtuendo();
    }

    //Para que sea un guardarropas compartido, le agrego el mismo a otro usuario y listo.
    public void agregarGuardarropas(Guardarropas guardarropas) {
        this.guardarropas.add(guardarropas);
    }

    public void setGuardarropasSeleccionado(Guardarropas guardarropasSeleccionado) {
        this.guardarropasSeleccionado = guardarropasSeleccionado;
    }
}
