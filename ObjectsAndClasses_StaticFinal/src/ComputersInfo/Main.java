package ComputersInfo;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("AsRock", "X-Machine 3000",
                new CPU(3.4, 16, "Intel", 0.027),
                new RAM(RAM.RAMType.DDR4, 32, 0.05),
                new Screen(27.8, Screen.ScreenType.IPS, 5.81),
                new Storage(Storage.StorageType.SSD, 2000, 0.046),
                new Keyboard(Keyboard.KeyboardType.MECHANICAL, true, 0.825));

        Computer computer1 = new Computer("Apple", "iMac GODLIKE series",
                new CPU(12.6, 16, "Intel", 0.237),
                new RAM(RAM.RAMType.DDR4, 32, 0.05),
                new Screen(400.1, Screen.ScreenType.IPS, 5.81),
                new Storage(Storage.StorageType.SSD, 2000, 0.236),
                new Keyboard(Keyboard.KeyboardType.MECHANICAL, true, 25));

        System.out.println(computer);
        System.out.println(computer1);
    }
}
