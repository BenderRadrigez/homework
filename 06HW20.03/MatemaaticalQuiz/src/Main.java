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
        int score;
        int continueGame;
        int randomChar;
        char[] operator = {'+', '-', '*', '/', '%'};

        printStartMessage();
        scanner.nextLine();

        while(true){
            firstNum = random.nextInt(50);
            secondNum = random.nextInt(50);
            randomChar = random.nextInt(5);

            result = matematicOperation(randomChar, firstNum, secondNum);

            System.out.println(firstNum + " " + operator[randomChar] + " " + secondNum);
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

        printFinalMessage(score);
    }

    static int matematicOperation(int randomOperatorNumber, int num1, int num2){
        if (randomOperatorNumber == 0) return num1 + num2;
        else if (randomOperatorNumber == 1) return num1 - num2;
        else if (randomOperatorNumber == 2) return num1 * num2;
        else if (randomOperatorNumber == 3) return num1 / num2;
        return num1 % num2;
    }

    static void printStartMessage(){
        System.out.println("Привет. я здесь, чтобы сыграть с тобой в игру...");
        System.out.println("Правила просты, я даю тебе математический пример('+,-,*,/,%') - ты отвечаешь.");
        System.out.println("Учти что результат деления нужно указать без остатка! только целое число(округление в меньшую сторону)!");
        System.out.println("Если ты ответишь не правильно ты проиграл. начнем?");
        System.out.println("нажми enter чтоб продолжить...");
    }

    static void printFinalMessage(int score){
        if (score == 1) System.out.println("молодец, даже самый маленький успех - все равно успех! ты заработал " + score + " очко.)");
        else if (score >= 2 && score <= 4 ) System.out.println("молодец, даже самый маленький успех - все равно успех! ты заработал " + score + " очка.)");
        else System.out.println("молодец, даже самый маленький успех - все равно успех! ты заработал " + score + " очков.)");
    }
}
