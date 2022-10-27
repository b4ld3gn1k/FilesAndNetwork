public class Arithmetic {
    private int numOne = 0;
    private int numTwo = 1;

    public Arithmetic(int numOne, int numTwo){
        this.numOne = numOne;
        this.numTwo = numTwo;
    }

    public int sumNum(){
        System.out.print("Сумма чисел: ");
        return numOne + numTwo;
    }

    public int productNum(){
        System.out.print("Произведение чисел: ");
        return numOne * numTwo;
    }

    public int maxFromTwoNum() {
        System.out.print("Маиксимальное из двух чисел: ");
        if (numOne > numTwo) {
            return numOne;
        }
        return numTwo;
    }

    public int minFromTwoNum(){
        System.out.print("Минимальное из двух чисел: ");
        if (numOne < numTwo) {
            return numOne;
        }
        return numTwo;
    }
}
