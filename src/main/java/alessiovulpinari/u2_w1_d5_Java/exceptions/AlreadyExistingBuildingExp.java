package alessiovulpinari.u2_w1_d5_Java.exceptions;

public class AlreadyExistingBuildingExp extends RuntimeException{
    public AlreadyExistingBuildingExp(String name, String address) {
        super("Esiste già un edificio con: " + name + " e indirizzo: " + address);
    }
}
