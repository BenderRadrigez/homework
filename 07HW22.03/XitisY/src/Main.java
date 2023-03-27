import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        System.out.println("было: " + firstNum + " " + secondNum);

        firstNum -= secondNum;
        secondNum -= -firstNum;
        firstNum = secondNum - firstNum;


        System.out.println("стало: " + firstNum + " " + secondNum);
    }
}