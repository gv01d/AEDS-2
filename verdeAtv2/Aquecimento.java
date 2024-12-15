import java.util.*;

public class Aquecimento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String test = scanner.nextLine();

        while (!test.equals("FIM")) {

            int c = 0;
            for (int i = test.length() - 1; i >= 0; i--) {

                int t = test.charAt(i);
                if (t <= 90 && t >= 65) {
                    c++;
                }
            }
            System.out.println(c);

            test = scanner.nextLine();
        }
    }

}