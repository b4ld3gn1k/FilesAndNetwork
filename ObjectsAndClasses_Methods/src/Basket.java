public class Basket {

    private static int countBasket = 0;
    private String items = "";
    private static int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    private static int count = 0;
    private static int totalPriceProduct;
    private static int totalCountProduct;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;

    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        Basket.totalPrice = totalPrice;
    }

    public static int getCountBasket() {
        return countBasket;
    }

    public static void increaseCount(int count) {

        Basket.countBasket = Basket.countBasket + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count){
        add(name, price, count, 1);
    }

    public void add(String name, int price, int count, double weight) {
        Basket.count = count;

        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;

        calcTotalCountProduct();
        calcTotalPriceProduct();

        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " + count + " шт. - " +
                price + " руб. - " + totalPrice + " всего. - " +
                weight + " вес. - " + totalWeight + " общий вес.";
    }



    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public double getTotalWeight(){
        return totalWeight;
    }

    public int getTotalPrice() {

        return totalPrice;
    }

    public boolean contains(String name) {

        return items.contains(name);
    }

    static int calcTotalPriceProduct(){
        return totalPriceProduct = totalPriceProduct + totalPrice;
    }

    static int calcTotalCountProduct(){
        return totalCountProduct = totalCountProduct + count;
    }

    static int getTotalPriceProduct(){
        return totalPriceProduct;
    }

    static int getTotalCountProduct(){
        return totalCountProduct;
    }

    static double averagePrice(){
        return (double) totalPriceProduct / totalCountProduct;
    }

    static double averagePriceOneBasket(){
        return (double) totalPriceProduct / countBasket;
    }

    public void print(String title) {
        System.out.println("\n" + title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }

    static void printTestMSG(){
        System.out.println(
                "\nОбщее колличество продуктов в корзинах: " + getTotalCountProduct() +
                "\nОбщая стоимость всех продуктов в корзинах: " + getTotalPriceProduct() + "\n");
        System.out.println("Средняя цена товара во всех корзинах: " + averagePrice() +
                "\nСредняя цена одной корзины: " + averagePriceOneBasket());
    }
}
