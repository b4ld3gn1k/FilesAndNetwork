package IntOrInteger;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ���� �������� ��� ��� ���������� �������:
        //  � ������� ����� � �������������� ����� � ������� ������� ��� ����
        //  ���� �������� �������� � ��������� � ��������, � ��� ����� ����� �.

        char c;
        int i;

        for (i = 1040; i <= 1103 ; i++) {
            c = (char) i;
            System.out.println(i + " | " + c);
            //1105 | 1103 - 1040 | 1025
            //�      � - �          �
        }
        System.out.println(i + " | " + (c = (char) 1025));
        System.out.println(i + " | " + (c = (char) 1105));

    }
}
