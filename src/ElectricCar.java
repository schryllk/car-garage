

public class ElectricCar extends Vehicle {

    // Constructors
    public ElectricCar() {

    }

    public ElectricCar(int year, Make make, String model, BodyType bodyType, String color, FuelType fuelType, int price,
            int maxSpeed, int fuelEfficiency) {
        super(year, make, model, bodyType, color, fuelType, price, maxSpeed, fuelEfficiency);

    }

    /**
     * @return this method will calculate the max distance based on the current
     *         battery level
     */
    @Override
    public int getMaxDistance(int fuelEfficiency) {
        int batteryLevel = 88;
        maxD = batteryLevel * fuelEfficiency;
        return maxD;
    }

    @Override
    public String toString() {
        return "Electric Car [Year: " + year + ", Make: " + make.getMake() + ", Model: " + getModel() + ", BodyType: "
                + bodyType.getBodyType() + ", Color: " + getColor()
                + ", FuelType: " + fuelType.getFuelType() + ", Price: $" + String.format("%,d", getPrice())
                + ", Max Speed: " + getMaxSpeed() + "mph"
                + ", MilesPerCharge: "
                + fuelEfficiency + "mpc]";
    }

}