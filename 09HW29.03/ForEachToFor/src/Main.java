public class Main {
    public static void main(String[] args) {
        Fruit[] fruits = {
                new Fruit("apple", true, "green"),
                new Fruit("cherry", true, "red/white/black"),
                new Fruit("banana", true, "yellow/green")
        };


        int iterationNum = 0;

        //   изменить данный цикл for each ...
        for (Fruit currentFruit : fruits) {
            System.out.println("Iteration: " + iterationNum);
            System.out.println("Fruit name: " + currentFruit.name);
            System.out.println("Fruit color: " + currentFruit.color);
            System.out.println("Fruit is tasty?: " + currentFruit.isTasty);
            iterationNum++;
        }

        System.out.println();
        //    на данный цикл for
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("Iteration: " + i);
            System.out.println("Fruit name: " + fruits[i].name);
            System.out.println("Fruit color: " + fruits[i].color);
            System.out.println("Fruit is tasty?: " + fruits[i].isTasty);
        }
    }
}