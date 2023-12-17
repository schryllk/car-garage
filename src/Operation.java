

import java.util.Scanner;

/** Operation Class will initiate the program */
public class Operation {

    Scanner scanner = new Scanner(System.in);
    Garage myGarage = new Garage();
    GarageManager myManager = new GarageManager(myGarage);
    private RegCar myRegCar = new RegCar();
    private ElectricCar myeCar = new ElectricCar();
    private AICar myAIcar = new AICar();

    String userInput;
    int userInputInt;
    boolean checkInventory = true;

    public Operation(Garage myGarage, GarageManager myManager) {
        this.myGarage = myGarage;
        this.myManager = myManager;
    }

    /** method that will initiate the garage sale/ start of the program */
    public void startGarageSale() {

        while (true) {
            // calls the Main Menu method to give user options to start
            myManager.mainMenu();
            userInput = scanner.nextLine();

            try {
                userInputInt = Integer.parseInt(userInput);
                // conditional statement that will execute whichever menu option the user
                // chooses

                // option #1
                if (userInputInt == 1) {
                    option_1();

                    // option #2
                } else if (userInputInt == 2) {
                    option_2();

                    // option #3
                } else if (userInputInt == 3) {
                    option_3();

                    // option #4
                } else if (userInputInt == 4) {
                    option_4();

                    // option #5
                } else if (userInputInt == 5) {
                    option_5();

                    // option #6
                } else if (userInputInt == 6) {
                    option_6();

                    // option #7
                } else if (userInputInt == 7) {
                    option_7();

                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try again.");
            }

        }

    }

    /**
     * @return method that will ask if the user would like to go back to the main
     *         menu
     */
    public boolean backToMainMenu() {
        System.out.println("Back to Main Menu? (y/n)");
        while (true) {
            String userInput = scanner.nextLine();
            try {
                if (userInput.equalsIgnoreCase("y")) {
                    return true;
                } else if (userInput.equalsIgnoreCase("n")) {
                    System.out.println("Thanks for stopping by! Goodbye.");
                    System.exit(0);
                    return false;
                } else {
                    System.out.println("INVALID INPUT! TRY AGAIN.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("INVALID INPUT! TRY AGAIN.");
            }
        }
    }

    /** Option 1 Display available cars */

    public void option_1() {
        myManager.carDisplay();
        backToMainMenu();

    }

    /** Option 2 Search a Car by Make */

    public void option_2() {
        System.out.println("Please enter the Make of the car you'd like to find?");
        while (true) {
            try {
                userInput = scanner.nextLine();
                myManager.searchCarByMake(myGarage.getCarMap(), userInput);
                backToMainMenu();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        }

    }

    /** Option 3 Test drive a car */
    public void option_3() {
        myManager.carDisplay();
        while (true) {
            System.out.println("Which Car would you like to test drive? (Enter the CarID number)");
            userInput = scanner.nextLine();

            try {
                userInputInt = Integer.parseInt(userInput);

                if (myGarage.carMap.containsKey(userInputInt)) {
                    myManager.testDrive();
                    FuelType typeOfCar = myGarage.carMap.get(userInputInt).getFuelType();
                    int fuelEfficiency = myGarage.getFuelEfficiency();

                    if (typeOfCar == FuelType.GAS || typeOfCar == FuelType.DIESEL) {
                        System.out.println("Max Distance for this Vehicle: "
                                + myRegCar.getMaxDistance(fuelEfficiency) + " miles");
                    } else if (typeOfCar == FuelType.ELECTRIC) {
                        System.out.println("Max Distance for this Electric Vehicle: "
                                + myeCar.getMaxDistance(fuelEfficiency) + " miles");
                    } else if (typeOfCar == FuelType.HYBRID) {
                        System.out.println("Max Distance for this AI Vehicle: "
                                + myAIcar.getMaxDistance(fuelEfficiency) + " miles");
                    }
                }

                System.out.println("Would you like to purchase the car? (y/n) ");
                userInput = scanner.nextLine().trim();

                while (userInput.isEmpty()) { // handles if the user pressed enter without input
                    System.out.println("Try Again! (y/n)");

                    userInput = scanner.nextLine();

                    if (userInput.equalsIgnoreCase("y")) {
                        //
                        System.out.println("Congratulations on your new ");
                        myManager.individualCarDisplay(userInputInt);
                        myManager.buyCar(userInputInt);
                        System.out.println();
                        backToMainMenu();
                        continue;

                    } else if (userInput.equalsIgnoreCase("n")) {
                        backToMainMenu();
                        continue;
                    }

                }

                if (userInput.equalsIgnoreCase("y")) {
                    System.out.println("Congratulations on your new ");
                    myManager.individualCarDisplay(userInputInt);
                    myManager.buyCar(userInputInt);
                    System.out.println();
                    backToMainMenu();
                    break;
                } else if (userInput.equalsIgnoreCase("n")) {
                    backToMainMenu();
                    break;
                } else {

                    System.out.println("Invalid Input! No such car");
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Please enter a valid number.");
            }

        }

    }

    /** Option 4 Sell your car */
    public void option_4() {
        myManager.sellCustomerCar();
        backToMainMenu();

    }

    /** Perform vehicle maintenance */
    public void option_5() {

        myManager.carDisplay();
        System.out.println("Enter the CarID of the vehicle you'd like to perform Maintenance: ");

        do {
            try {
                userInput = scanner.nextLine();
                userInputInt = Integer.parseInt(userInput);

                if (myGarage.doesCarExist(userInputInt)) {
                    myManager.doMaintenance();
                    backToMainMenu();
                    break;
                } else {
                    System.out.println("INVALID INPUT! Try Again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("INVALID INPUT! Try Again.");
            }
        } while (true);

    }

    /** Option 6 View customer reviews */
    public void option_6() {
        myManager.customerReviews();
        backToMainMenu();

    }

    /** Option 7 Exit program */
    public void option_7() {

        System.out.println("Thanks for stopping by! Goodbye.");
        System.exit(0);

    }

}
