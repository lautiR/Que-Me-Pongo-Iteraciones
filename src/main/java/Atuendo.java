import excepciones.AtuendoInvalidoException;
import prenda.Categoria;
import prenda.Prenda;

public class Atuendo {
    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private Prenda calzado;
    private Prenda accesorio;

    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado, Prenda accesorio) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
        this.accesorio = accesorio;
        this.validarCategorias();
    }
    private void validarCategorias(){
        if(!this.prendaSuperior.getCategoria().equals(Categoria.SUPERIOR)
                || !this.prendaInferior.getCategoria().equals(Categoria.INFERIOR)
                || !this.calzado.getCategoria().equals(Categoria.CALZADO)
                || !this.accesorio.getCategoria().equals(Categoria.ACCESORIO)) {
            throw new AtuendoInvalidoException("Alguna Prenda ingresada no corresponde a su categoría");
        }

    }
}
