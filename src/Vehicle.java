

public abstract class Vehicle {
    // private Random random = new Random();

    public int year;
    public Make make;
    public String model;
    public BodyType bodyType;
    public String color;
    public FuelType fuelType;

    public int fuelEfficiency;
    public int price = 0;
    public int maxSpeed;
    public int maxD;

    // Constructor
    public Vehicle() {

    }

    public Vehicle(int year, Make make, String model, BodyType bodyType, String color, FuelType fuelType, int price,
            int maxSpeed, int fuelEfficiency) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.bodyType = bodyType;
        this.color = color;
        this.fuelType = fuelType;
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.fuelEfficiency = fuelEfficiency;
    }

    public int getYear() {
        return year;
    }

    public Make getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getFuelEfficiency() {
        return fuelEfficiency;
    }

    /**
     * @return an abstract method that will determine the max distance depending on
     *         the type of vehicle
     */
    public abstract int getMaxDistance(int fuelEfficiency);

}
