import java.util.*;

class Palindromo {

    static String PoliTest(String tester) {

        for (int i = tester.length() - 1; i >= tester.length() / 2; i--) {

            if (tester.charAt(i) != tester.charAt(tester.length() - 1 - i)) {
                return "NAO";
            }
        }
        return "SIM";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String Test = scanner.nextLine();

        while (!Test.equals("FIM")) {

            MyIO.println(PoliTest(Test));

            Test = scanner.nextLine();
        }
    }
}