import prenda.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTipoYCategoriaPrenda{


    Prenda camisa = new Prenda(
            TipoPrenda.CAMISA,
            new Colour(255,0,0), //ROJO
            null,
            Material.ALGODON,
            null,
            null
            );

    @Test
    public void unaPrendaTipoCamisaEsCategoriaSuperior()
    {
        Assertions.assertEquals(camisa.getCategoria(), Categoria.SUPERIOR);
    }





}
