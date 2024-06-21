package alessiovulpinari.u2_w1_d5_Java.exceptions;

public class AlredyExistingEmailException extends RuntimeException{
    public AlredyExistingEmailException(String email) {
        super("Esiste già un utente con questa mail: " + email);
    }
}
