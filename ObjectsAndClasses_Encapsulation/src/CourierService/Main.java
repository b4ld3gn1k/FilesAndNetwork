package CourierService;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(15, 15, 15);

        Dimensions newHeight = dimensions.setHeight(1);
        Dimensions newLength = dimensions.setLength(4);
        Dimensions newWeight = dimensions.setHeight(3);

        Dimensions newGabr = dimensions.setNewDimensions(4,1,1);

        CargoInfo cargoInfo = new CargoInfo(
                37.5,
                "EKB",
                "sdjhfg875667HJFGHF7HJH",
                true,
                false,
                newGabr);

        CargoInfo newMass = cargoInfo.setMass(124.124);
        CargoInfo newAddress = cargoInfo.setAddress("Moscow");

        System.out.println(newMass + "\n" + newAddress);
    }
}
