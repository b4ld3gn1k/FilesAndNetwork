package ComputersInfo;

public class Computer {
    private CPU cpu;
    private RAM ram;
    private Screen screen;
    private Storage storage;
    private Keyboard keyboard;

    private final String vendor;
    private final String name;



    public Computer(String vendor, String name, CPU cpu, RAM ram, Screen screen, Storage storage, Keyboard keyboard){
        this.cpu = cpu;
        this.ram = ram;
        this.screen = screen;
        this.storage = storage;
        this.keyboard = keyboard;
        this.name = name;
        this.vendor = vendor;
    }
    public double totalWeight(){
        return cpu.getWeightCPU() + ram.getWeight() + screen.getWeight() + storage.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "Производитель: " + vendor + ". Имя компьютера: " + name +
                ".\nКомплектующие этого компьютера: \n" +
                "1. CPU: " + cpu +
                "\n2. RAM: " + ram +
                "\n3. Screen: " + screen +
                "\n4. Storage: " + storage +
                "\n5. Keyboard: " + keyboard +
                "\nОбщий вес компьютера составляет - " + totalWeight() + " кг.\n";
    }
}
