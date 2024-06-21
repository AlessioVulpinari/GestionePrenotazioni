package alessiovulpinari.u2_w1_d5_Java.exceptions;

public class AlreadyExistingEmailException extends RuntimeException{
    public AlreadyExistingEmailException(String email) {
        super("Esiste già un utente con questa mail: " + email);
    }
}
