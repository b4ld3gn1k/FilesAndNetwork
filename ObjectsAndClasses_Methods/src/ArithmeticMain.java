public class ArithmeticMain {

    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(78, 2);

        System.out.println("���������� ��������� ������� ����� 15 � 26\n");
        System.out.println(arithmetic.sumNum());
        System.out.println(arithmetic.productNum());
        System.out.println(arithmetic.maxFromTwoNum());
        System.out.println(arithmetic.minFromTwoNum());
    }
}
