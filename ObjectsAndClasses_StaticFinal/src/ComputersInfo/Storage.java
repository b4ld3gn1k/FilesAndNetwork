package ComputersInfo;

public class Storage {
    private final StorageType storageType;
    private final int volume;
    private final double weight;

    public Storage (StorageType storageType, int volume, double weight){
        this.storageType = storageType;
        this.volume = volume;
        this.weight = weight;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public Storage setStorageType(StorageType storageType){
        return new Storage(storageType, volume, weight);
    }

    public Storage setVolume(int volume){
        return new Storage(storageType, volume, weight);
    }

    public Storage setWeight(double weight){
        return new Storage(storageType, volume, weight);
    }

    public String toString() {
        return "Тип хранилища - " + storageType +
                ". Объем - " + volume + " GB" +
                ". Вес - " + weight + " кг.";
    }
}
