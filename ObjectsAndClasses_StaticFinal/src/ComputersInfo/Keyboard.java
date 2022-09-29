package ComputersInfo;

public class Keyboard {
    private final KeyboardType keyboardType;
    private final boolean isLight;
    private final double weight;

    public Keyboard(KeyboardType keyboardType, boolean isLight, double weight) {
        this.keyboardType = keyboardType;
        this.isLight = isLight;
        this.weight = weight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public boolean isLight() {
        return isLight;
    }

    public double getWeight() {
        return weight;
    }

    public Keyboard setKeyboardType(KeyboardType keyboardType){
        return  new Keyboard(keyboardType, isLight, weight);
    }

    public Keyboard setLight(boolean isLight){
        return  new Keyboard(keyboardType, isLight, weight);
    }

    public Keyboard setWeight(double weight){
        return  new Keyboard(keyboardType, isLight, weight);
    }

    public String toString() {
        return "Тип клавиатуры - " +keyboardType +
                ". Подсветка - " + isLight +
                ". Вес - " + weight + " кг.";
    }
}
