package CourierService;

public class Dimensions {

    private final int weight; //ширина см
    private final int length; //длина см
    private final int height; //высота см

    private int dimensions; //габариты м3

    public Dimensions(int weight, int length, int height){
        this.weight = weight;
        this.length = length;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public Dimensions setWeight(int weight) {
        return new Dimensions(weight, length, height);
    }

    public int getLength() {
        return length;
    }

    public Dimensions setLength(int length) {
        return new Dimensions(weight, length, height);
    }

    public int getHeight() {
        return height;
    }

    public Dimensions setHeight(int height) {
        return new Dimensions(weight, length, height);
    }

    public int dimensionsM3(){
        return dimensions = weight * length * height;
    }

}
