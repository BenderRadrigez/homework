public class Main {
    public static void main(String[] args) {
        String[][] hangmanPics = { {"+---+", "    |", "    |" , "    |", " ===="},
                {"+---+", "  O |",  "    |" , "    |", " ===="},
                {"+---+", "  O |",  "  | |" , "    |", " ===="},
                {"+---+", "  O |",  " /| |" , "    |", " ===="},
                {"+---+", "  O |",  " /|\\|" , "    |", " ===="},
                {"+---+", "  O |",  " /|\\|" , " /  |", " ===="},
                {"+---+", "  O |",  " /|\\|" , " / \\|", " ===="},
        };

        String[][] words = {
                {"квадрат треугольник прямоугольник круг эллипс ромб трапеция параллелограмм пятиугольник шестиугольник восьмиугольник"},
                {"яблоко апельсин лимон лайм груша мандарин виноград грейпфрут персик банан абрикос манго нектарин"},
                {"аист акула бабуин баран барсук бобр бык верблюд волк воробей ворон выдра голубь гусь жаба зебра" +
                        " змея индюк кит кобра коза козел койот корова кошка кролик крыса курица лама ласка лебедь лев лиса лосось лось лягушка медведь моллюск" +
                        " моль мул муравей мышь норка носорог обезьяна овца окунь олень орел осел панда паук питон попугай пума семга скунс собака сова тигр тритон" +
                        " тюлень утка фарель хорек черепаха ястреб ящерица"}};

    }


    public static void printHangmanPics(String[][] hangmanPics){
        for( int i = 0; i < hangmanPics.length; i++){
            for (String hung : hangmanPics[i]) {
                System.out.println(hung);
            }
            System.out.println();
        }
    }
}

// все слова - делились на категории
//взять рандомное слово
//метод который скрывает слово
//метод который при угадывании буквы показывает ее в скрытом слове
//метод если игрок не угадывает букву выводи в консоль виселицу (с каждой не угаданной буквой добавляем к висилице элемент)
//метод проверки на победу
//уровень сложности