import excepciones.AtuendoInvalidoException;
import prenda.Categoria;
import prenda.Prenda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usuario {
    private List<Prenda>prendas=new ArrayList<>();
    private AccuWeatherAPI apiClima;

    public Usuario(List<Prenda> prendas, AccuWeatherAPI apiclima) {
        this.prendas = prendas;
        this.apiClima = apiclima;
    }

    public Atuendo sugerirAtuendo() {
        List<Map<String, Object>>estadoDelTiempo = apiClima.getWeather("Buenos Aires, Argentina");
        BigDecimal temperatura = (BigDecimal) estadoDelTiempo.get(0).get("Temperature");
        return obtenerAtuendoSegunTemperatura(temperatura);
    }

    //Este método devuelve el atuendo generado LUEGO de haber filtrado ropas aptas para el Clima
    private Atuendo obtenerAtuendoSegunTemperatura(BigDecimal temperatura) {
        List<Prenda> prendasAptas =  this.prendas.stream()
                .filter(prenda -> prenda.soyAdecuadaParaElClima(temperatura))
                .collect(Collectors.toList());
        return this.generarAtuendo(prendasAptas);
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

    private Prenda obtenerPrendaDeLaCategoria(List<Prenda> prendas, Categoria categoria) {
        return prendas.stream()
                .filter(p->p.getCategoria().equals(categoria))
                .findFirst()
                .orElse(null);
    }


}
