
/**
 * main class the will call the Operation to start the program
 * 
 * @author Schryll Schuch
 */
public class App {
    public static void main(String[] args) {
        Garage myGarage = new Garage();
        GarageManager myManager = new GarageManager(myGarage);

        Operation garageSale = new Operation(myGarage, myManager);
        garageSale.startGarageSale();

    }
}
