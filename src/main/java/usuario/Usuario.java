package usuario;

import usuario.Guardarropas;

import java.util.List;

public class Usuario {
    private List<Guardarropas> guardarropas;

    public Usuario(List<Guardarropas> guardarropas) {
        this.guardarropas = guardarropas;
    }

    //Para que sea un guardarropas compartido, le agrego el mismo a otro usuario y listo.
    public void agregarGuardarropas(Guardarropas guardarropas) {
        this.guardarropas.add(guardarropas);
    }
}
