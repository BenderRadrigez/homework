import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //создаем массив из рандомных чисел и заполняем его
        int[] arrayNumbers = new int[10];
        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = random.nextInt(1000);
        }
        //выводим массив и уточняем как его отсортировать
        System.out.println("Привет я создал массив из 10 рандомных чисел: ");
        for (int num : arrayNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Как нужно отсортировать массив? на увеличение(true) на уменьшение(false)");
        boolean isIncrease = scanner.nextBoolean();
        //сортируем, перезаписываем и выводим массив
        arrayNumbers = sorter(arrayNumbers, isIncrease);

        for (int num : arrayNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("мишон комплит!)");
    }

    public static int[] sorter(int[] numbers, boolean isIncrease){
        int num;
        if(isIncrease){
            for (int i = 0; i < numbers.length - 1; i++){
                for(int j = i + 1; j < numbers.length; j++){
                    if (numbers[i] > numbers[j]) {
                        num = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = num;
                    }
                }
            }
        }else {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[i] < numbers[j]) {
                        num = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = num;
                    }
                }
            }
        }
        return numbers;
    }
}