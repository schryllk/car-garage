
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GarageManager {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private Garage myGarage = new Garage();

    int handlingAndManeuverability;
    int comfort;
    int engineOil;
    int breakPads;
    int batteryLife;

    boolean foundCars = false; // no cars found , this will be used for the carsByMake method

    // Constructor
    public GarageManager(Garage garage) {
        this.myGarage = garage;
        this.engineOil = random.nextInt(11);
        this.breakPads = random.nextInt(11);
        this.batteryLife = random.nextInt(11);

    }

    /** this method will display the Main Menu options for the user */
    public void mainMenu() {
        System.out.println();
        System.out.println("+--------------------+\r\n" + //
                "|WELCOME TO MY GARAGE|\r\n" + //
                "+--------------------+");
        System.out.println("Please choose from the following option:");
        System.out.println("1. View Available Cars in the Garage");
        System.out.println("2. Search Cars by Make(Manufacturer)");
        System.out.println("3. Test Drive a car");
        System.out.println("4. Sell your car");
        System.out.println("5. Perform a vehicle maintenance");
        System.out.println("6. View customer reviews");
        System.out.println("7. Exit");

    }

    /** this method will "Start, drive a single vehicle" test drive */
    public void testDrive() {
        carDisplay();
        movingCar();
        displayStats();
    }

    /**
     * displays the Handling/Maneuverability, comfort rating and maxSpeed
     * stats
     */
    public void displayStats() {

        handlingAndManeuverability = random.nextInt(11);
        comfort = random.nextInt(11);

        System.out.println("Handling and Maneuverability: " + handlingAndManeuverability + "/10");
        System.out.println("Comfort: " + comfort + "/10");

    }

    /** Displays Customer Reviews */
    public void customerReviews() {
        System.out.println();
        System.out.println(":::::Customer Reviews:::::");
        System.out.println("-Best Car Garage project I have seen yet!  - John");
        System.out.println("-Great Customer Service, It was so easy to sell my car. -Zac");
        System.out.println("-Their site is user friendly I will be back for future purchases! -Sam  ");
        System.out.println();
    }

    /** method that will remove car from the Hashmap */
    public void buyCar(int whichCar) {
        if (myGarage.carMap.containsKey(whichCar)) {
            myGarage.carMap.remove(whichCar);
        } else {
            System.out.println("INVALID INPUT!");
        }
    }

    /**
     * @return returns a uniqueNumber to use for assigning a Key to each car added
     *         to the HashMap
     */
    private int uniqueIDGenerator() {
        return 100 + myGarage.carMap.size() + 1;
    }

    /** method that will add a vehicle in the Garage hashMap */
    public void sellCustomerCar() {
        myGarage.regCar = new RegCar(0, null, null, null, null, null, 0, 0, 0);

        int year = 0;
        while (year == 0) {
            try {
                System.out.println("Enter the year of the car: ");
                year = Integer.valueOf(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        Make make = null;
        while (make == null) {

            System.out.println("Enter car make (ie.Honda, BMW):");

            try {
                make = Make.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        String model = null;
        while (model == null) {

            try {
                System.out.println("Enter the model of the car: ");
                model = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        BodyType bodyType = null;
        while (bodyType == null) {
            System.out.println("Enter the car's body type (COUPE, SUV, SEDAN, TRUCK, SPORTS): ");
            try {
                bodyType = BodyType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("INVALID INPUT! Try Again.");

            }
        }

        String color = null;
        while (color == null) {
            try {
                System.out.println("Enter the car's color:");
                color = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        FuelType fuelType = null;
        while (fuelType == null) {
            System.out.println("What powers the vehicle (GAS, ELECTRIC, HYBRID, DIESEL)?: ");
            try {
                fuelType = FuelType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        int price = -1;
        while (price < 0) {
            try {
                System.out.println("Enter sell price: ");
                String iPrice = scanner.nextLine();
                price = Integer.parseInt(iPrice);
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        int maxSpeed = 0;
        while (maxSpeed == 0) {
            try {
                System.out.println("Enter the car's max speed: ");
                String iMaxSpeed = scanner.nextLine();
                maxSpeed = Integer.valueOf(iMaxSpeed);
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        int fuelEfficiency = 0;
        while (fuelEfficiency == 0) {
            try {
                System.out.println("Enter Fuel Efficiency (mpg): ");
                String iFuelE = scanner.nextLine();
                fuelEfficiency = Integer.valueOf(iFuelE);
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

        // create a vehicle to add to the Garage HashMap based on the user input
        Vehicle newCar = null; // initializing newCar to null ensure the variable is initialized with a known
                               // state.

        if (fuelType == FuelType.ELECTRIC) {

            newCar = new ElectricCar(year, make, model, bodyType, color, fuelType, price, maxSpeed, fuelEfficiency);

        } else if (fuelType == FuelType.GAS) {

            newCar = new RegCar(year, make, model, bodyType, color, fuelType, price, maxSpeed, fuelEfficiency);

        } else if (fuelType == FuelType.HYBRID) {

            newCar = new AICar(year, make, model, bodyType, color, fuelType, price, maxSpeed, fuelEfficiency);
        }

        // Adding the customer's car to the current carMap
        myGarage.carMap.put(uniqueIDGenerator(), newCar);
    }

    /**
     * this method will search the hashmap in the Garage class so the user
     * can search a car by Make
     */
    public void searchCarByMake(Map<Integer, Vehicle> carMap, String carMake) {

        Set<Integer> keys = new HashSet<>();
        Make make;
        int carCounter = 0;

        do {
            try {
                make = Make.valueOf(carMake.toUpperCase()); // since Make is an enum this will convert the string input
                                                            // to match enum value

                for (Map.Entry<Integer, Vehicle> availableCar : carMap.entrySet()) {
                    int carId = availableCar.getKey();
                    Vehicle car = availableCar.getValue();
                    if (car.getMake() == make) {
                        keys.add(carId);
                        carCounter++;

                        System.out.println("Total number of " + make + " cars found in the garage:  " + carCounter);
                        break;
                    }
                }

                if (keys.isEmpty()) {
                    System.out.println("No car(s) found in the garage for make: " + make);

                }
                break; // exits the loop

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Input!");
                return;
            }
        } while (true);
    }

    /** method that will perform basic maintenance */
    public void doMaintenance() {
        try {
            System.out.println(checkEngineOil());
            Thread.sleep(1000);
            System.out.println(inspectBreak());
            Thread.sleep(1000);
            System.out.println(batteryHealth());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /** @return method the will check the vehicles engine oil health */
    public String checkEngineOil() {
        int engineOil = random.nextInt(11);

        if (engineOil > 5 && engineOil <= 10) {
            return "EngineOil: Good";
        } else {
            try {

                Thread.sleep(1000);
                System.out.println("Engine Oil: Not Good");
                Thread.sleep(1000);
                System.out.println("Performing Maintenance...");
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Engine Oil: Good";
        }

    }

    /** @return method that will check the vehicle break pads */
    public String inspectBreak() {
        int breakPads = random.nextInt(11);

        if (breakPads > 5 && engineOil <= 10) {
            return "Break Pads: Good";

        } else {
            try {
                Thread.sleep(1000);
                System.out.println("Break Pads: Not Good");
                Thread.sleep(1000);
                System.out.println("Performing Maintenance...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Break Pads: Good";
        }

    }

    /** @return method that will maintain battery health */
    public String batteryHealth() {
        return "BatteryHealth: Good";
    }

    /**
     * method to call if i just want to display 1 particular car from the
     * HashMap using the key
     */
    public void individualCarDisplay(int carID) {
        Vehicle car = myGarage.carMap.get(carID);

        if (car != null) {

            Vehicle carToRetrieve = myGarage.carMap.get(carID);
            System.out.print(carToRetrieve.getYear());
            System.out.print(" " + carToRetrieve.getMake());
            System.out.print(" " + carToRetrieve.getModel());

        } else {
            System.out.println("No car found with ID: " + carID + " in the garage.");
        }
    }

    /** method that will display the cars that are in the garage hashmap */
    public void carDisplay() {

        System.out.println("$+-+-+-+-+ +-+-+-+ +-+-+-+-+-+$\r\n" + //
                "$|C|A|R|S| |F|O|R| |S|A|L|E|!|$\r\n" + //
                "$+-+-+-+-+ +-+-+-+ +-+-+-+-+-+$\r"); //

        // this loop will iterate over the carMap entries and print each entry on a new
        // line
        for (Map.Entry<Integer, Vehicle> cars : myGarage.getCarMap().entrySet()) {
            int key = cars.getKey();
            Vehicle vehicle = cars.getValue();
            System.out.println("CarID: " + key);
            System.out.println(vehicle); // This will use the overridden toString() method
            System.out.println("---------------------------"); // Separator between entries
        }

    }

    /**
     * method that will depict a simple animation of a moving car to use for
     * test driving
     */
    public void movingCar() {

        long startTime = System.currentTimeMillis();
        long duration = 3300; // 3.3 seconds in milliseconds
        int position = 0;

        while (System.currentTimeMillis() - startTime < duration) {
            clearConsole(); // Clear the console to create the illusion of movement
            printCar(position); // Print the car at the current position
            position++;
            try {
                Thread.sleep(50); // Delay for 100 milliseconds between frames
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /** method that clears the console. */
    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /*** this will print out a visual illustration of a car */
    private static void printCar(int position) {
        // Print the car at the specified position
        StringBuilder car = new StringBuilder();
        car.append(" ".repeat(Math.max(0, position))); // Spaces before the car
        car.append(" ______\n"); // Car body
        car.append(" ".repeat(Math.max(0, position)));
        car.append("|======|__\n"); // Car body
        car.append(" ".repeat(Math.max(0, position)));
        car.append("|__[]_|_|_\\\n"); // Car roof and back
        car.append(" ".repeat(Math.max(0, position)));
        car.append("(o)----(o)"); // Car wheels
        System.out.println(car.toString());
    }

}
