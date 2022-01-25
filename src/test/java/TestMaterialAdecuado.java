import excepciones.MaterialInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import prenda.*;

public class TestMaterialAdecuado {
    @Test
    public void LenteDeTelaNoEsAdecuado() {
        PrendaBuilder builder = new PrendaBuilder(Trama.LISA);
        builder.setTipoPrenda(TipoPrenda.LENTES);
        Assertions.assertThrows(MaterialInvalidoException.class, ()->builder.setMaterial(Material.ALGODON));
    }
    @Test
    public void LenteDePlasticoEsAdecuado() {
        PrendaBuilder builder = new PrendaBuilder(Trama.LISA);
        builder.setTipoPrenda(TipoPrenda.LENTES);
        Assertions.assertDoesNotThrow(()->builder.setMaterial(Material.PLASTICO));
    }
}
