public class Main {
    public static void main(String[] args) {

        String strVar = "I study Basic Java!";

        char charVar = strVar.charAt(18);
        System.out.println(charVar);

        boolean hereIsJava = strVar.contains("Java");
        System.out.println(hereIsJava);

        String strVarWithO = strVar.replace('a', 'o');
        System.out.println(strVarWithO);

        String strVarToUpper = strVar.toUpperCase();
        System.out.println(strVarToUpper);

        String strVarToLower = strVar.toLowerCase();
        System.out.println(strVarToLower);

        String strVarOnlyJava = strVar.substring(14);
        System.out.println(strVarOnlyJava);
    }
}