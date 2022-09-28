public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Clever", 15, 178, 1.5);
        basket.add("jojo", 124, 3);
        basket.add("fajo", 1247);
        basket.print("Dasha");

        Basket basket1 = new Basket();
        basket1.add("Castle", 184575, 2);
        basket1.add("Zebra", 458, 7, 27.5);
        basket1.print("John III");

        Basket basket2 = new Basket();
        basket2.add("huje", 7896, 36);
        basket2.add("erth", 76, 1);
        basket2.add("worm", 7896, 6);
        basket2.print("IZYA");

        Basket.printTestMSG();
    }
}
