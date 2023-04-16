import CategoryOfWords.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int counterOfErrors = 0;     //счетчик ошибок
    static  String usedChars = "";      //использованные буквы
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printStartMessage();            //приветствие и правила
        String word = wordForQuestions(random.nextInt(4));  //выбор слова из 4 категорий
        String mysteryWord = mysteryWord(word);         //прячем слово

        //ход игры
        while (true){
            System.out.print("введите букву: ");    //просим ввести букву
            System.out.println(mysteryWord);        //показываем скрытое слово с постепенно открывающимися буквами
            mysteryWord = wordWithOpenCharacter(word, mysteryWord);     //перезаписываем поле со скрытыми буквами
            System.out.println("использованные буквы: " + usedChars);   //показываем буквы которые уже использовались
            if(isWinner(word, mysteryWord)) {       //проверяем на победу
                System.out.println("правильно, загаданное слово это - " + word);
                break;
            } else if (counterOfErrors == 6) {        //или проигрыш
                System.out.println("ты проиграл, загаданное слово - " + word);
                break;
            }
        }

    }
    public static void printStartMessage(){
        System.out.println("В И С Е Л И Ц А");
        printHangmanPics(counterOfErrors);
        System.out.println("я загадываю слово, и говорю к какой категории оно относится, а вам нужно называя буквы угадать его.");
        System.out.println("с каждой неправильной буквой я дорисовываю часть человечка на виселице, у вас будет 6 попыток. начнем!");
        System.out.println("!важно! для игры обязательно используйте русскоязычную расскладку!");
        scanner.nextLine();
    }
    public static void printHangmanPics(int value){
        String[][] hangmanPics = { {"+---+", "    |", "    |" , "    |", " ===="},
                {"+---+", "  O |",  "    |" , "    |", " ===="},
                {"+---+", "  O |",  "  | |" , "    |", " ===="},
                {"+---+", "  O |",  " /| |" , "    |", " ===="},
                {"+---+", "  O |",  " /|\\|" , "    |", " ===="},
                {"+---+", "  O |",  " /|\\|" , " /  |", " ===="},
                {"+---+", "  O |",  " /|\\|" , " / \\|", " ===="},
        };

        for( int i = 0; i < hangmanPics[value].length; i++){
            System.out.println(hangmanPics[value][i]);
        }
        System.out.println();
    }
    public static String wordForQuestions(int number){
        System.out.print("слово из категории: ");
        switch (number){
            case 0:
                System.out.println("звери");
                return new Animals().word;
            case 1:
                System.out.println("цвета");
                return new Colors().word;
            case 2:
                System.out.println("геометрические фигуры");
                return new Figure().word;
            default:
                System.out.println("фрукты");
                return new Fruits().word;
        }
    }
    public static String mysteryWord(String word){
        String mystery = "";
        for(int i = 1; i <= word.length(); i++){
            mystery += "_";
        }
        return mystery;
    }
    public static String wordWithOpenCharacter(String word, String mysteryWord){
        char character = scanner.nextLine().charAt(0);
        boolean flag = false;
        String somethingStr = "";

        for(int i = 0; i < usedChars.length(); i++){
            if (character == usedChars.charAt(i)){
                System.out.println("эта буква уже была");
                return mysteryWord;
            }
        }
        usedChars += " " + character;
        for (int i = 0; i < word.length(); i++){
            if(word.charAt(i) == character){
                somethingStr += character;
                flag = true;
            }
            else somethingStr += mysteryWord.charAt(i);
        }

        if(!flag){
            counterOfErrors++;
            printHangmanPics(counterOfErrors);
        }
        return somethingStr;
    }
    public  static boolean isWinner(String word, String mysteryWord){
        int counterTruthChars = mysteryWord.length();
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == mysteryWord.charAt(i)) counterTruthChars--;
        }
        return counterTruthChars == 0;
    }
}

//++приветствие и правила
//++все слова - делились на категории
//++взять рандомное слово
//++метод который скрывает слово
//++метод который при угадывании буквы показывает ее в скрытом слове
//++метод если игрок не угадывает букву выводи в консоль виселицу (с каждой не угаданной буквой добавляем к виселице элемент)
//++метод проверки на победу
//уровень сложности
