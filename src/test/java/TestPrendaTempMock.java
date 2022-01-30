import clima.PronosticadorClima;
import org.junit.jupiter.api.BeforeEach;
import prenda.*;

import java.math.BigDecimal;

public class TestPrendaTempMock {

    private Prenda remera;
    private Prenda malla;
    private Prenda zapatillas;
    private Prenda lentes;
    private Prenda aros;
    private PronosticadorClima pronosticadorClimaMock;

    @BeforeEach
    public void init() {
        remera = new Prenda(TipoPrenda.REMERA,new Colour(0,0,0)
                ,null, Material.ALGODON, Trama.LISA,new BigDecimal("35.5"));
        malla = new Prenda(TipoPrenda.PANTALON,new Colour(0,0,0)
                ,null, Material.ALGODON, Trama.LISA,new BigDecimal("35.5"));
        zapatillas = new Prenda(TipoPrenda.ZAPATILLA,new Colour(0,0,0)
                ,null, Material.TELA, Trama.LISA,new BigDecimal("35.5"));
        lentes = new Prenda(TipoPrenda.LENTES,new Colour(0,0,0)
                ,null, Material.PLASTICO, Trama.LISA,new BigDecimal("35.5"));
        aros = new Prenda(TipoPrenda.AROS,new Colour(0,0,0)
                ,null, Material.ORO, Trama.LISA,new BigDecimal("10.5"));
    }




}
