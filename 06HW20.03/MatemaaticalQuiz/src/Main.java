import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int firstNum;
        int secondNum;
        int result;
        int answer;
        int score = 0;
        int continueGame;
        boolean flag = true;

        System.out.println("Привет. я здесь, чтобы сыграть с тобой в игру...");
        System.out.println("Правила просты, я даю тебе математический пример на сложение - ты отвечаешь.");
        System.out.println("Если ты ответишь не правильно ты проиграл. начнем?");
        System.out.println("нажми enter чтоб продолжить...");
        scanner.nextLine();

        while(flag){
            firstNum = random.nextInt(50);
            secondNum = random.nextInt(50);
            result = firstNum + secondNum;

            System.out.println(firstNum + " " + "+" + " " + secondNum);
            answer = scanner.nextInt();

            if (answer != result) {
                System.out.println("ты проиграл, правильный ответ " + result + ". Но не расстраивайся ты -");
                break;
            }

            score++;

            System.out.println("правильный ответ, ты заработал +1 очко, твой счет составляет: " + score);
            System.out.println("чтобы продолжить выбери 1 чтобы завершить нажми 0");
            continueGame = scanner.nextInt();
            if (continueGame == 0) break;
        }

        if (score == 1) System.out.println("молодец, даже самый маленький успех - все равно успех! ты заработал " + score + " очко.)");
        else if (score >= 2 && score <= 4 ) System.out.println("молодец, даже самый маленький успех - все равно успех! ты заработал " + score + " очка.)");
        else System.out.println("молодец, даже самый маленький успех - все равно успех! ты заработал " + score + " очков.)");
    }
}