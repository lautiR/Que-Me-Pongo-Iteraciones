import excepciones.TipoPrendaException;

import java.awt.*;

public class Prenda {
    private TipoPrenda tipoPrenda;
    private Colour colorPrincipal;
    private Colour colorSecundario;
    private Material material;

    public Prenda(TipoPrenda tipoPrenda, Colour colorPrincipal, Colour colorSecundario, Material material) {
        if(tipoPrenda==null) {
            throw new TipoPrendaException("El tipo de prenda no puede ser nulo");
        }
        this.tipoPrenda = tipoPrenda;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.material = material;
    }
}
