package ComputersInfo;

public class RAM {
    private final RAMType ramType;
    private final int volume;
    private final double weight;

    public RAM(RAMType ramType, int volume, double weight) {
        this.ramType = ramType;
        this.volume = volume;
        this.weight = weight;
    }

    public RAMType getRamType() {
        return ramType;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public RAM setRAMType(RAMType ramType){
        return new RAM(ramType, volume, weight);
    }

    public RAM setVolume(int volume){
        return new RAM(ramType, volume, weight);
    }

    public RAM setWeight(double weight){
        return new RAM(ramType, volume, weight);
    }

    public String toString() {
        return "Тип памати - " + ramType +
                ". Объем - " + volume + " GB" +
                ". Вес - " + weight + " кг.";
    }
}
