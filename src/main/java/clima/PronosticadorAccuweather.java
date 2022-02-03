package clima;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PronosticadorAccuweather implements PronosticadorClima{

    private AccuWeatherAPI api;

    public PronosticadorAccuweather(AccuWeatherAPI api) {
        this.api = api;
    }

    @Override
    //ADAPTER, delego en la API la busqueda y yo la devuevlo como quierom
    // aunque aca no cambio nada para simplificar
    public BigDecimal getTemperature(String ciudad) {
        return (BigDecimal) this.api.getWeather(ciudad).get(0).get("Temperature");
    }

    @Override
    public List<Alerta> getAlertas(String ciudad) {
        Map<String, Object> alertas = api.getAlertas(ciudad);
        return adaptarListaAlertas(alertas,ciudad);
    }

    //HARDCODEADO porque la API no tiene esta implementacion
    private List<Alerta> adaptarListaAlertas(Map<String, Object> alertasMap,String key) {
        return  Arrays.asList(Alerta.TORMENTA,Alerta.GRANIZO);
    }
}
