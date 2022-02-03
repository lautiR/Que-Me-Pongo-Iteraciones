package usuario;

import java.util.List;

public class RepoUsuario {
    private List<Usuario> usuarios;

    public RepoUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
