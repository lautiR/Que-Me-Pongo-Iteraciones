import clima.AccuWeatherAPI;
import prenda.*;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Probando cosas
        PrendaBuilder prendaBuilder = new PrendaBuilder(Trama.LISA);

        prendaBuilder.setTipoPrenda(TipoPrenda.CAMISA);

        prendaBuilder.setColorPrincipal(new Colour(0,0,255));

        prendaBuilder.setMaterial(Material.ALGODON);

        prendaBuilder.darDeAltaPrenda();

        AccuWeatherAPI api = new AccuWeatherAPI();
        List<Map<String, Object>>estadoDelTiempo = api.getWeather("Buenos Aires, Argentina");
        System.out.println(estadoDelTiempo.get(0));
    }
}
