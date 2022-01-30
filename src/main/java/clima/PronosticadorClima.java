package clima;

import java.math.BigDecimal;

public interface PronosticadorClima {
  BigDecimal getTemperature(String ciudad);
}
