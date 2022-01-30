package usuario;

import clima.PronosticadorClima;
import prenda.Atuendo;
import prenda.Categoria;
import prenda.Prenda;
import propuestas.PropuestaModificacionPrenda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropas {
    private List<Prenda>prendas;
    private PronosticadorClima pronosticadorClima;
    private List<PropuestaModificacionPrenda> propuestasModificacionPrenda;

    public Guardarropas(List<Prenda> prendas, PronosticadorClima pronosticadorClima) {
        this.prendas = prendas;
        this.pronosticadorClima = pronosticadorClima;
        this.propuestasModificacionPrenda = new ArrayList<>();
    }

    public Atuendo sugerirAtuendo() {
        BigDecimal temperatura = this.pronosticadorClima.getTemperature("Buenos Aires, Argentina");
        return obtenerAtuendoSegunTemperatura(temperatura);
    }
    public void agregarPrenda(Prenda prenda) {
        this.prendas.add(prenda);
    }
    public void removerPrenda(Prenda prenda) {
        this.prendas.remove(prenda);
    }
    public void aceptarPropuesta(PropuestaModificacionPrenda propuesta) {
        propuesta.ejecutar(this);
    }

    //Este componente en realidad seria un desarrollo externo que nos darian. voy a hardcodearlo
    public Atuendo generarAtuendo (List<Prenda> prendas) {
        Prenda superior = this.obtenerPrendaDeLaCategoria(prendas,Categoria.SUPERIOR);
        Prenda inferior = this.obtenerPrendaDeLaCategoria(prendas,Categoria.INFERIOR);
        Prenda calzado = this.obtenerPrendaDeLaCategoria(prendas,Categoria.CALZADO);
        Prenda accesorio = this.obtenerPrendaDeLaCategoria(prendas,Categoria.ACCESORIO);
        //El atuendo tiene un validador en constructor
        return new Atuendo(superior,inferior,calzado,accesorio);
    }

    //Mutabilidad para elegir el pronosticador especifico que necesite
    public void setPronosticadorClima(PronosticadorClima pronosticadorClima) {
        this.pronosticadorClima = pronosticadorClima;
    }

    public void agregarPropuesta(PropuestaModificacionPrenda propuesta) {
        this.propuestasModificacionPrenda.add(propuesta);
    }

    //Este método devuelve el atuendo generado LUEGO de haber filtrado ropas aptas para el Clima
    private Atuendo obtenerAtuendoSegunTemperatura(BigDecimal temperatura) {
        List<Prenda> prendasAptas =  this.prendas.stream()
                .filter(prenda -> prenda.soyAdecuadaParaElClima(temperatura))
                .collect(Collectors.toList());
        return this.generarAtuendo(prendasAptas);
    }

    private Prenda obtenerPrendaDeLaCategoria(List<Prenda> prendas, Categoria categoria) {
        return prendas.stream()
                .filter(p->p.getCategoria().equals(categoria))
                .findFirst()
                .orElse(null);
    }


}
