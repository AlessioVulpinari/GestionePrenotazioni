package alessiovulpinari.u2_w1_d5_Java.exceptions;

public class ToShortException extends RuntimeException {
    public ToShortException(String name) {
        super(name + " ha pochi caratteri.");
    }
}
