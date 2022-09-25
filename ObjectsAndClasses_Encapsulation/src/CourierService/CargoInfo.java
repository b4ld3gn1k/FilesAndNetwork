package CourierService;

public class CargoInfo {
    private final Dimensions dimensions;
    private final double mass; //вес

    private final String address; //адрес доставки
    private final String registrationNumber; //регистрационный номер

    private final boolean isFragile;//можно ли переворачивать
    private final boolean isTurn;//является ли зрупким


    public CargoInfo(double mass, String address, String registrationNumber,
                     boolean isFragile, boolean isTurn, Dimensions dimensions) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
        this.isTurn = isTurn;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public CargoInfo setDimensions(Dimensions dimensions){
        return new CargoInfo(mass, address, registrationNumber, isFragile, isTurn, dimensions);
    }

    public double getMass() {
        return mass;
    }

    public CargoInfo setMass(double mass){
        return new CargoInfo(mass, address, registrationNumber, isFragile, isTurn, dimensions);
    }

    public String getAddress() {
        return address;
    }

    public CargoInfo setAddress(String address){
        return new CargoInfo(mass, address, registrationNumber, isFragile, isTurn, dimensions);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public String toString() {
        return "Масса: " + mass +
                " | Адрес: " + address +
                " | Рег.Номер: " + registrationNumber +
                " | Является ли хрупким: " + isFragile +
                " | Можно ли переворачивать: " + isTurn + " | " + dimensions;
    }
}
