

import java.util.HashMap;
import java.util.Map;

public class Garage {
    public Map<Integer, Vehicle> carMap;
    RegCar regCar;
    ElectricCar eCar;
    AICar aiCar;
    Make make;
    BodyType bodyType;
    FuelType fuelType;
    int fuelEfficiency = 25;


    // Constructor
    public Garage() {
        this.carMap = new HashMap<>();
        this.regCar = new RegCar(2023, make, "CRV", bodyType, "Blue", fuelType, 0, 0, 0);
        this.eCar = new ElectricCar(2024, make, " ", bodyType, " ", fuelType, 0, 0, 0);
        this.aiCar = new AICar(2024, make, " ", bodyType, " ", fuelType, 0, 0, 0);

        // adding predefined cars to my hashMap(Garage) with unique ID
        carMap.put(101, new RegCar(2023, Make.HONDA, "CRV", BodyType.SUV, "Black", FuelType.GAS, 25000, 160, 25));
        carMap.put(102,
                new ElectricCar(2024, Make.TESLA, "Model S", BodyType.SEDAN, "Grey", FuelType.ELECTRIC, 100000, 200,
                        50));
        carMap.put(103, new AICar(2024, Make.BMW, "AI Dee", BodyType.SUV, "White",
                FuelType.HYBRID, 135000, 170, 30));

    }

    public Map<Integer, Vehicle> getCarMap() {
        return carMap;
    }

    /** this method check's the Hashmap if a particular key exist **/
    public boolean doesCarExist(int carID) {
        return carMap.containsKey(carID);
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setFuelEfficiency(int fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public Make getMake() {
        return make;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void buyVehicle(int vehicleID, Vehicle vehicle) {
        carMap.put(vehicleID, vehicle);
    }

    public void sellVehicle(int vehicleID, Vehicle vehicle) {
        carMap.remove(vehicleID, vehicle);
    }

}
