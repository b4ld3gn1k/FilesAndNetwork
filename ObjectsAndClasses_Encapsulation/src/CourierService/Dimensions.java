package CourierService;

public class Dimensions {

    private final int weight; //ширина см
    private final int length; //длина см
    private final int height; //высота см

    private int dimensions; //габариты м3

    public Dimensions(int weight, int length, int height) {
        this.weight = weight;
        this.length = length;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Dimensions setWeight (int weight){
        return new Dimensions(weight, length, height);
    }

    public Dimensions setLength (int length){
        return new Dimensions(weight, length, height);
    }

    public Dimensions setHeight (int height){
        return new Dimensions(weight, length, height);
    }

    public Dimensions setNewDimensions (int weight, int length, int height){
        return new Dimensions(weight, length, height);
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public String toString() {
        dimensions = weight * length * height;
        return "Габариты: " + dimensions + " м3";
    }

}
