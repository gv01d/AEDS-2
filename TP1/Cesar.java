import java.io.*;
import java.nio.charset.*;

public class Cesar {

    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    private static PrintStream out = new PrintStream(System.out, true, Charset.forName("ISO-8859-1"));

    public static void main(String[] args) {
        String testing = "";
        try {
            testing = in.readLine();
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        while (!testing.equals("FIM")) {

            testing += "\n";
            String result = "";
            int n = 0;

            while (testing.charAt(n) != '\n') {
                result += (char) (testing.charAt(n) + 3);
                n++;
            }

            try {
                out.println(result);
            } catch (Exception e) {
                System.err.println(e);
                return;
            }

            try {
                testing = in.readLine();
            } catch (Exception e) {
                System.err.println(e);
                return;
            }
        }
    }
}