package sugerencia;

import prenda.Atuendo;
import usuario.RepoUsuario;
import usuario.Usuario;

import java.util.List;

public class SugeridorAtuendos {
    private List<Atuendo> atuendos;
    private RepoUsuario repoUsuario;
    private List<SugerenciaClima> sugerenciasEmitidas;

    public SugeridorAtuendos(List<Atuendo> atuendos,
                             RepoUsuario repoUsuario,
                             List<SugerenciaClima> sugerenciasEmitidas) {
        this.atuendos = atuendos;
        this.repoUsuario = repoUsuario;
        this.sugerenciasEmitidas = sugerenciasEmitidas;
    }

    void calcularSugerenciaDiaria() {
        this.repoUsuario.getUsuarios().forEach(Usuario::sugerirAtuendo);
    }

}
