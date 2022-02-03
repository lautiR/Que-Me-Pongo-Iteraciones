package clima;

import java.util.ArrayList;
import java.util.List;

public class RegistroAlertas {
    private List<Alerta>alertas = new ArrayList<>();
    private PronosticadorClima pronosticadorClima;

    public RegistroAlertas(PronosticadorClima pronosticadorClima) {
        this.pronosticadorClima = pronosticadorClima;
    }

    public void setPronosticadorClima(PronosticadorClima pronosticadorClima) {
        this.pronosticadorClima = pronosticadorClima;
    }

    public void actualizarAlertas() {
        this.alertas = this.pronosticadorClima.getAlertas("Buenos Aires, Argentina");
    }
}
