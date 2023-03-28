import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNum;
        int secondNum;
        boolean isOddOrEven;

        Scanner scanner = new Scanner(System.in);

        System.out.println("пожалуйста дайте мне два числа для сложения:");
        firstNum = scanner.nextInt();
        secondNum = scanner.nextInt();
        isOddOrEven = isEven(firstNum, secondNum);
        System.out.println("число " + (isOddOrEven ? "четное" : "нечетное"));
    }

    static boolean isEven(int numA, int numB){
        return (numA + numB) % 2 == 0;
    }
}
