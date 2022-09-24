package CourierService;

public class CargoInfo {
    private Dimensions dimensions;
    private final double mass; //вес

    private final String address; //адрес доставки
    private final String registrationNumber; //регистрационный номер

    private final boolean isFragile; //является ли зрупким
    private final boolean isTurn; //можно ли переворачивать

    public CargoInfo(Dimensions dimensions, double mass, String address, String registrationNumber, boolean isFragile, boolean isTurn) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
        this.isTurn = isTurn;
    }

    public void print(){
        System.out.println("Масса: " + mass +
                " | Адрес: " + address +
                " | Рег.Номер: " + registrationNumber +
                " | Является ли хрупким: " + isFragile +
                " | Можно ли переворачивать: " + isTurn + " | " + dimensions);
    }

    public CargoInfo setMass(int mass){
        return new CargoInfo(dimensions, mass, address, registrationNumber, isFragile, isTurn);
    }

    public CargoInfo setAddress(String address){
        return new CargoInfo(dimensions, mass, address, registrationNumber, isFragile, isTurn);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getMass() {
        return mass;
    }

    public String getAddress() {
        return address;
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
}
