import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int firstNum, secondNum;       //числа для математической операции
        int result;         //результат математической операции
        int answer;         //ответ пользователя
        int randomChar;     //выбор символа для математической операции
        int numberOfPlayers; //колличество игроков
        int value = 5;      //очки которые добавляем или отнимаем у игроков
        int numberOfQuestions = 5;  //кол-во вопросов

        String[] arrayNameOfPlayers;    //массив из имен игроков
        int[] arrayScoreOfPlayers;      //массив очков для каждого игрока
        char[] operator = {'+', '-', '*', '/', '%'};

        printStartMessage();        //стартовое приветсвие

        //получаем кол-во игроков и массив из имен
        do {
            arrayNameOfPlayers = howManyPlayersInGame();
            numberOfPlayers = arrayNameOfPlayers.length;
            arrayScoreOfPlayers = new int[numberOfPlayers];
        } while (numberOfPlayers == 0);

        //процесс игры
        for(int i = 0; i < numberOfQuestions; i++){
            for(int j = 0; j < numberOfPlayers; j++){
                System.out.println("Вопрос " + (i+1) + " для игрока " + arrayNameOfPlayers[j]);
                firstNum = random.nextInt(50);
                secondNum = random.nextInt(50);
                randomChar = random.nextInt(5);

                result = matematicOperation(randomChar, firstNum, secondNum);

                System.out.print(firstNum + " " + operator[randomChar] + " " + secondNum + " = ");
                answer = scanner.nextInt();

                if (answer != result) {
                    System.out.print("ответ " + answer + " не верный, правильный ответ " + result + ".");
                    arrayScoreOfPlayers[j] -= value;
                } else {
                    System.out.print("правильный ответ, ты заработал +5 очков");
                    arrayScoreOfPlayers[j] += value;
                }
                System.out.println(" у тебя уже " + arrayScoreOfPlayers[j] + " очков");
            }
        }
        //завершение игры
        whoIsWin(arrayNameOfPlayers, arrayScoreOfPlayers);
    }

    static int matematicOperation(int randomOperatorNumber, int num1, int num2){
        switch (randomOperatorNumber) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            case 3: return num1 / num2;
            default: return num1 % num2;
        }
    }

    static String[] howManyPlayersInGame(){
        System.out.println("Скажите сколько игроков хочет поучаствовать в игре?");
        String[] arrayPlayers = new String[scanner.nextInt()];
        for(int i = 0; i < arrayPlayers.length; i++){
            System.out.println("Введите имя " + (i+1) + "-го игрока:");
            arrayPlayers[i] = scanner.next();
        }
        return arrayPlayers;
    }

    static void printStartMessage(){
        System.out.println("Привет. вы здесь, чтобы сыграть в игру...");
        System.out.println("Правила просты, я даю математический пример('+,-,*,/,%') - вы отвечаете по очереди.");
        System.out.println("Учтите что результат деления нужно указать без остатка! только целое число(округление в меньшую сторону)!");
        System.out.println("За каждый правильный ответ участник получает 5 баллов, если ответ не правильный он их теряет. начнем?");
        System.out.println("нажми enter чтоб продолжить...");
        scanner.nextLine();
    }

    static void whoIsWin(String[] arrayNames, int[] arrayScores){
        String someString;
        int someValue, index;

        for(int i = 0; i < arrayScores.length; i++){
            index = i;
            for (int j = i; j < arrayScores.length; j++){
                if (arrayScores[j] > arrayScores[i]){
                    index = j;
                }
            }
            someValue = arrayScores[i];
            arrayScores[i] = arrayScores[index];
            arrayScores[index] = someValue;

            someString = arrayNames[i];
            arrayNames[i] = arrayNames[index];
            arrayNames[index] = someString;
        }
        System.out.println();

        for (int i = 0; i < arrayNames.length; i++){
            System.out.println((i+1) + " место занимает " + arrayNames[i] + "! Набрав " + arrayScores[i] + " очков.");
        }
    }
}
