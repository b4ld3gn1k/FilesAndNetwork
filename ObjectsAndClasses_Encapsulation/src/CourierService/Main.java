package CourierService;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(15, 15, 15);
        CargoInfo cargoInfo = new CargoInfo(dimensions,
                35.7,
                "Omsk",
                "765HJFG7hjgf&987",
                true,
                false);

        cargoInfo.setMass(1234);
        cargoInfo.setAddress("EKB");

        cargoInfo.print();
    }
}
