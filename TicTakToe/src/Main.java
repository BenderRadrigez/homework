import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        String placeholder = "* ";          //указываем заполнитель полей
        String[][] matrixBoard = board(new String[4][4], placeholder);  //создаем поле для игры и заполняем его нейтрильными значениями
        int counterForEquals = 5;           //счетчик для ничьей

        printStartMessage(placeholder);     //приветсвие с правилами
        //узнаем в каком режиме игра
        if(howManyPlayer() == 1){       //против компьютера
            System.out.println("Игрок ходит 'X' представьтесь:");
            String player1 = scanner.next();
            System.out.println("Компьютер ходит '0'");
            //игровой процесс
            for(int i = 0; i < counterForEquals; i++){
                System.out.println("Ходит " + player1);
                matrixBoard = playerStep(matrixBoard, placeholder, 1);      //изменяем поле по указанным параметрам
                printOfBoard(matrixBoard);                                              //показываем поле
                //проверяем на победу
                if(isWinner(matrixBoard, "X ")){
                    System.out.println("Ты победил! Поздравляем! действительно человек умнее любой машины!");
                    break;
                }
                //проверяем на ничью
                if(i == counterForEquals - 1){
                    System.out.println("Ничья, это еще не проигрыш но и не победа! постарайся и ты обязательно выиграешь!");
                    break;
                }
                //те же условия для компьютера - компьютер ходит, показываем поле, проверяем на победу
                System.out.println("Ходит компьютер");
                matrixBoard = computerStep(matrixBoard, placeholder);
                printOfBoard(matrixBoard);
                if(isWinner(matrixBoard, "0 ")){
                    System.out.println("К сожалению компьютер победил, но не отчаивайся, попробуй еще раз и у тебя точно получится!");
                    break;
                }
            }
        } else{     //для двух игроков
            System.out.println("Игрок 1 ходит 'X' представьтесь:");
            String player1 = scanner.next();
            System.out.println("Игрок 2 ходит '0' представьтесь:");
            String player2 = scanner.next();
            //игровой процесс
            for(int i = 0; i < counterForEquals; i++){
                System.out.println("Ходит " + player1);
                matrixBoard = playerStep(matrixBoard, placeholder, 1);
                printOfBoard(matrixBoard);
                if(isWinner(matrixBoard, "X ")){
                    System.out.println(player1 + " в этот раз оказался сильнее чем " + player2 + ", Поздравляем!");
                    break;
                }
                if(i == counterForEquals - 1){
                    System.out.println("Ничья, это еще не проигрыш но и не победа!");
                    break;
                }
                System.out.println("Ходит " + player2);
                matrixBoard = playerStep(matrixBoard, placeholder, 2);
                printOfBoard(matrixBoard);
                if(isWinner(matrixBoard, "0 ")){
                    System.out.println(player2 + " в этот раз оказался сильнее чем " + player1 + ", Поздравляем!");
                    break;
                }
            }
        }
    }

    static void printStartMessage(String placeholder){
        System.out.println("Приветствую! Предлагаю сыграть во всем известную игру - КРЕСТИКИ-НОЛИКИ!");
        System.out.println("правила просты:");
        printOfBoard(board(new String[4][4], placeholder));
        System.out.println("на поле 3х3 клетки игроки поочереди расставляют крестики или нолики в не занятые клетки,\n" +
                "победителем окажется тот - кто первым заполнит все три клетки (по горизонтали, вертикали\n" +
                "или по диагонали) своим символом.");
        System.out.println("нажмите Enter для продолжения...");
        scanner.nextLine();
    }
    static int howManyPlayer(){
        System.out.println("сколько человек хочет сыграть? 1 - против компьютера, 2 - друг против друга");
        return scanner.nextInt();
    }
    static String[][] playerStep(String[][] matrix, String placeholder, int numberPlayers){
        int horizontal, vertical;
        boolean isNotFree = true;

        while (isNotFree){
            System.out.println("укажите горизонталь 1-3:");
            horizontal = scanner.nextInt();
            System.out.println("укажите вертикаль 1-3:");
            vertical = scanner.nextInt();
            if (matrix[horizontal][vertical].equals(placeholder) && numberPlayers == 1) {
                matrix[horizontal][vertical] = "X ";
                isNotFree = false;
            }else if (matrix[horizontal][vertical].equals(placeholder) && numberPlayers == 2) {
                matrix[horizontal][vertical] = "0 ";
                isNotFree = false;
            } else System.out.println("эта позиция уже занята.");
        }
        return matrix;
    }
    static String[][] computerStep(String[][] matrix, String placeholder){
        int horizontal, vertical;
        boolean isNotFree = true;

        while (isNotFree){
            horizontal = random.nextInt(2) + 1;
            vertical = random.nextInt(2) + 1;
            if (matrix[horizontal][vertical].equals(placeholder)) {
                matrix[horizontal][vertical] = "0 ";
                isNotFree = false;
            }
        }
        return matrix;
    }
    static String[][] board(String[][] matrix, String placeholder){
        int counter;

        for(int i = 0; i < matrix.length; i++){
            counter = i;
            for (int j = 0; j < matrix[i].length; j++){
                if(i + j == counter || i == 0) {
                    matrix[i][j] = counter + " ";
                    counter++;
                    if(i != 0) counter = i;
                }
                else matrix[i][j] = placeholder;

            }
        }
        return matrix;
    }
    static void printOfBoard(String[][] matrix){
        for (String[] horizontal : matrix){
            for(String vertical : horizontal){
                System.out.print(vertical);
            }
            System.out.println();
        }
    }
    static boolean isWinner(String[][] matrix, String whoIsIt){
        if((matrix[1][1].equals(matrix[1][2]) && matrix[1][3].equals(whoIsIt)) ||
        (matrix[2][1].equals(matrix[2][2]) && matrix[2][3].equals(whoIsIt)) ||
        (matrix[3][1].equals(matrix[3][2]) && matrix[3][3].equals(whoIsIt)) ||
        (matrix[1][1].equals(matrix[2][1]) && matrix[3][1].equals(whoIsIt)) ||
        (matrix[1][2].equals(matrix[2][2]) && matrix[3][2].equals(whoIsIt)) ||
        (matrix[1][3].equals(matrix[2][3]) && matrix[3][3].equals(whoIsIt)) ||
        (matrix[1][1].equals(matrix[2][2]) && matrix[3][3].equals(whoIsIt)) ||
        (matrix[1][3].equals(matrix[2][2]) && matrix[3][1].equals(whoIsIt))){
            return true;
        }
        return false;
    }

    //-main -реализация
    //++  начало игры
    //++      приветсвие и правила
    //++      возможность выбора: игрок против компьютера, игрок против игрока
    //+-  ход игры
    //++      создать поле для игры 3х3
    //++      проверка на занятость локации
    //+-!!!      проверка на победу, проигрыш или ничью !!!(появился баг: после первого хода второго игрока - игрок 2 объявляется победителем)
    //++  обьявление победителя
}