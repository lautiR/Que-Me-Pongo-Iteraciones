package clima;

import java.math.BigDecimal;
import java.util.List;

public interface PronosticadorClima {
  BigDecimal getTemperature(String ciudad);
  List<Alerta> getAlertas(String ciudad);
}
