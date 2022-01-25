import excepciones.IngresoDeDatosPrendaIncorrectoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import prenda.*;

public class TestPrendaBuilder {

    @Test
    public void noPuedoAsignarMaterialPrendaSinAntesAsignarTipo() {
        PrendaBuilder builder = new PrendaBuilder(Trama.LISA);
        Assertions.assertThrows(
                IngresoDeDatosPrendaIncorrectoException.class,
                ()-> builder.setMaterial(Material.ALGODON)
        );
    }
    @Test
    public void ingresoUnaPrendaConsistente() {
        PrendaBuilder builder = new PrendaBuilder(Trama.LISA);
        Assertions.assertDoesNotThrow(()->builder.setTipoPrenda(TipoPrenda.PANTALON));
        Assertions.assertDoesNotThrow(()->builder.setMaterial(Material.CUERO));
        Assertions.assertDoesNotThrow(()->builder.setColorPrincipal(new Colour(255,255,255)));
        Assertions.assertDoesNotThrow(builder::darDeAltaPrenda);
    }

}
