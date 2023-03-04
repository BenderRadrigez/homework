public class Main {
    public static void main(String[] args) {
        //думаю не беда, если я вынес две переменные за методы, так на мой взгляд симпатичнее и проще менять
        int firstNum = 5;
        int secondNum = 2;

        add(firstNum, secondNum);
        sub(firstNum, secondNum);
        multiplication(firstNum, secondNum);
        division(firstNum, secondNum);
    }

    public static void add(int firstNum, int secondNum){
        System.out.println(firstNum + secondNum);
    }

    public static void sub(int firstNum, int secondNum){
        System.out.println(firstNum - secondNum);
    }

    public static void multiplication(int firstNum, int secondNum){
        System.out.println(firstNum * secondNum);
    }

    public static void division(double firstNum, double secondNum){
        System.out.println(firstNum / secondNum);
    }
}