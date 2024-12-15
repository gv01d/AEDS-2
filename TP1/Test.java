import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class Test {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true, Charset.forName("UTF-8"));

    public static void main(String[] args) {
        try {
            String s = "";

            while ((s = in.readLine()) != null) {

                out.println(s);
            }

            out.println("end");

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}