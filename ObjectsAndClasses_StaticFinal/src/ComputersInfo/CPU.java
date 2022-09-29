package ComputersInfo;

public class CPU {
    private final double frequency; //частота
    private final int countCores; //колличество ядер
    private final String manufacturer; //производитель
    private final double weight; //вес

    public CPU(double frequency, int countCores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.countCores = countCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public double getWeightCPU(){
        return weight;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getCountCores() {
        return countCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public CPU setCPUFrequency(double frequency){
        return new CPU(frequency, countCores, manufacturer, weight);
    }

    public CPU setCPUCores(int countCores){
        return new CPU(frequency, countCores, manufacturer, weight);
    }

    public CPU setCPUManufacture(String manufacturer){
        return new CPU(frequency, countCores, manufacturer, weight);
    }

    public CPU setCPUWeight(double weight){
        return new CPU(frequency, countCores, manufacturer, weight);
    }

    public String toString() {
        return "Частота - " + frequency + " MHZ" +
                ". Колличество ядер - " + countCores +
                ". Производитель - " + manufacturer +
                ". Вес - " + weight + " кг.";
    }
}
