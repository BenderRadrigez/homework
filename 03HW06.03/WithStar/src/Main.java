import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String values = "0123456789ABCDEF";

        System.out.println("пожалуйста введите цифру из какой системы счисления будем переводить: ");
        int numberFrom = scanner.nextInt();
        System.out.println("пожалуйста введите цифру в какую систему счисления будем переводить: ");
        int numberTo = scanner.nextInt();
        System.out.println("введите число которое хотите перевести: ");

        if (numberFrom == 10){
            int valueNumber = scanner.nextInt();
            tenToOther(values, valueNumber, numberTo);

        } else if (numberTo == 10) {
            String valueStringNumber = scanner.next();
            otherToTen(values, valueStringNumber, numberFrom);
        }

        System.out.println("вы хотите разложить на разряды? да - 1, нет - 0");
        int yesOrNot = scanner.nextInt();
        if (yesOrNot == 1){
            System.out.println("введите число:");
            String valueStringNumber = scanner.next();
            System.out.println("введите цифрой систему счисления: ");
            int valueFromSystem = scanner.nextInt();

            numberIntoDigit(values, valueStringNumber, valueFromSystem);
        }
    }

    //метод для перевода в десятичную систему
    public static void otherToTen(String values, String number, int valueOfSystem){
        int num = 0;
        int result = 0;

        for (int i= 0; i < number.length(); i++){
            num = values.indexOf(number.charAt(i));
            result += num * Math.pow(valueOfSystem, number.length()-i-1);
        }
        System.out.println(result);
    }

    //метод для перевода из десятичной в другие
    public static void tenToOther(String value, int number, int valueOfSystem){
        int num = 0;
        String result = "";

        while (number != 0){
            num = number % valueOfSystem;
            if (num > 9){
                result = value.charAt(num) + result;
            }
            else{
                result = num + result;
            }
            number = number / valueOfSystem;
        }

        System.out.println(result);
    }

    //метод для разложения на разряды
    public static void numberIntoDigit(String values, String number, int valueOfSystem){
        int num = 0;
        int result = 0;
        double preResult = 0;

        for (int i = 0; i < number.length(); i++){
            //20012 = (2 × 3^4) + (0 × 3^3) + (0 × 3^2) + (1 × 3^1) + (2 × 3^0) =
            System.out.print("(" + number.charAt(i) + " * " + valueOfSystem + "^" + (number.length() - i - 1));
            if (i != number.length() - 1) {
                System.out.print(") + ");
            }else{
                System.out.print(") = ");
            }
        }
        for (int i = 0; i < number.length(); i++){
            //20012 = 162 + 0 + 0 + 3 + 2 = 16710
            num = values.indexOf(number.charAt(i));
            preResult = num * Math.pow(valueOfSystem, number.length()-i-1);
            result += preResult;
            if (i != number.length() - 1) {
                System.out.print(preResult + " + ");
            }else{
                System.out.print(preResult + " = " +  result);
            }

        }
    }
}