import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNum;
        int secondNum;
        boolean oddOrEven;

        Scanner scanner = new Scanner(System.in);

        System.out.println("пожалуйста дайте мне два числа для сложения:");
        firstNum = scanner.nextInt();
        secondNum = scanner.nextInt();
        oddOrEven = isOdd(firstNum, secondNum);
        System.out.println("число " + (oddOrEven ? "четное" : "Нечетное"));
    }

    static boolean isOdd(int numA, int numB){

        return (numA + numB) % 2 == 0;
    }
}