import java.util.*;
import java.io.*;
import java.nio.charset.*;

public class RngChange {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true, Charset.forName("UTF-8"));

    static String change(char A, char B, String text) {
        // Creating variables
        String result = "";
        text += "\n";

        // Testing for ocurences of A to swap with B
        for (int i = 0; text.charAt(i) != '\n'; i++) {
            if (text.charAt(i) == A) {
                result += B;
            } else {
                result += text.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try {

            // Reading Text
            String text = in.readLine();

            // creating random
            Random rng = new Random();
            rng.setSeed(4);

            // Redoing
            while (!text.equals("FIM")) {

                char Rand1 = (char) ('a' + (Math.abs(rng.nextInt()) % 26));
                char Rand2 = (char) ('a' + (Math.abs(rng.nextInt()) % 26));
                // Changing and Printing result
                out.println(change(Rand1, Rand2, text));

                // re-reading and restarting
                text = in.readLine();
            }

        } catch (Exception e) {

        }

    }
}
