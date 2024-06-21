package alessiovulpinari.u2_w1_d5_Java.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String id) {
        super("Elemento con id: " + id + " non trovato");
    }
}
