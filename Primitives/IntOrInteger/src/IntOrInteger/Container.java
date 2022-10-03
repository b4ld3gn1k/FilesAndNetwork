package IntOrInteger;

public class Container {
    private Integer count = new Integer(0);

    public void addCount(int value) {
        count = count + value;
    }

    public int getCount() {
        return count;
    }
}
