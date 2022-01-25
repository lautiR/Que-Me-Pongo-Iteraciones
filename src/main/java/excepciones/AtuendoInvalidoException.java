package excepciones;

import java.util.function.Supplier;

public class AtuendoInvalidoException extends RuntimeException {
    public AtuendoInvalidoException (String mensaje) {super(mensaje);
    }
}
