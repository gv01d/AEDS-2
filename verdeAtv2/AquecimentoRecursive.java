import java.util.*;

public class AquecimentoRecursive {

    public static int tester(String testing) {
        if (testing.length() != 0) {

            int t = testing.charAt(testing.length() - 1);
            testing = testing.substring(0, testing.length() - 1);

            if (t <= 90 && t >= 65) {

                return 1 + tester(testing);
            } else {
                return 0 + tester(testing);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String test = scanner.nextLine();

        while (!test.equals("FIM")) {

            System.out.println(tester(test));

            test = scanner.nextLine();
        }
    }

}