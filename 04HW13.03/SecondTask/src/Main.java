public class Main {
    public static void main(String[] args) {
        byte byteVar = 8;
        int intVar = 10;
        double doubleVar = 1.5;
        float floatVar = 1.1F;

        byte byteVar2 = (byte) intVar;
        int intVar2 = byteVar;
        double doubleVar2= intVar2;
        int intVar3 = (int) doubleVar + (int) floatVar;


        System.out.println(byteVar2 + "\n" + intVar2 + "\n" + doubleVar2 + "\n" + intVar3);
    }
}