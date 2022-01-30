package clima;

import java.math.BigDecimal;

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
}
