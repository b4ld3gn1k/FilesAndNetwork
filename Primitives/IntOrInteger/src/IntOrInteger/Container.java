package IntOrInteger;

public class Container {

    int i = 0;
    private Integer count = i;

    public void addCount(int value) {
        count = count + value;
    }

    public int getCount() {
        return count;
    }
}
