package alessiovulpinari.u2_w1_d5_Java.exceptions;

public class AlredyExistingBuildingExp extends RuntimeException{
    public AlredyExistingBuildingExp(String name, String address) {
        super("Esiste già un edificio con: " + name + " e indirizzo: " + address);
    }
}
