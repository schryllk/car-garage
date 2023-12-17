public class AICar extends Vehicle {

    // Constructors
    public AICar() {

    }

    public AICar(int year, Make make, String model, BodyType bodyType, String color, FuelType fuelType, int price,
            int maxSpeed,
            int fuelEfficiency) {
        super(year, make, model, bodyType, color, fuelType, price, maxSpeed, fuelEfficiency);
    }

    /**
     * @return this method will calculate the max distance based on the current fuel
     *         Level and the cars fuel efficiency
     */
    @Override
    public int getMaxDistance(int fuelEfficiency) {
        int fuelLevel = 78;
        maxD = fuelLevel * fuelEfficiency;
        return maxD;
    }

    @Override
    public String toString() {
        return "AI (Self Driving) Car [Year: " + year +
                ", Make: " + make.getMake() + ", Model: " + getModel() + ", BodyType: " + bodyType.getBodyType()
                + ", Color: " + getColor()
                + ", FuelType: " + fuelType.getFuelType()
                + ", Price: $" + String.format("%,d", getPrice()) + ", Max Speed: " + getMaxSpeed() + "mph"
                + ", FuelEfficiency: " + fuelEfficiency
                + "mpg] ";
    }

}