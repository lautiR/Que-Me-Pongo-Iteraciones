package prenda;


import java.math.BigDecimal;

public class Prenda {
    private TipoPrenda tipoPrenda;
    private Colour colorPrincipal;
    private Colour colorSecundario;
    private Material material;
    private Trama trama;
    private BigDecimal temperaturaMaxima;

    //Con este constructor y sus excepciones, evito que la prenda me quede en estdo incosistente,
    //según mis reglas de negocio


    public Prenda(TipoPrenda tipoPrenda, Colour colorPrincipal, Colour colorSecundario,
                  Material material, Trama trama, BigDecimal temperaturaMaxima) {
        this.tipoPrenda = tipoPrenda;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.trama = trama;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public Categoria getCategoria() {
        return this.tipoPrenda.getCategoria();
    }
    public Boolean soyAdecuadaParaElClima(BigDecimal temperatura) {
        return this.temperaturaMaxima.doubleValue() < temperatura.doubleValue();
    }

}
