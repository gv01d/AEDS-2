import java.util.ArrayList;

public class Boolalg {

    static ArrayList<Integer> list = new ArrayList<>();
    static String text;
    static String buffer;
    static int bufferpos = 0;
    static Boolean returning;

    // Reads the buffer and returns the returning state
    static boolean BufferReader() {
        if (buffer.charAt(bufferpos) == '\n')
            return true;
        text = "";
        // buffer reader while cheking for divisions ('(),')
        char t = buffer.charAt(bufferpos);
        bufferpos++;
        while (t != '(' && t != ')') {
            // Checking for breakpoint
            if (t == '\n')
                return true;
            // Checking for ',', sets returning state
            if (t != ',') {
                // Filtering space
                if (t != ' ') {
                    text += t;
                }
            } else
                return false;
            t = buffer.charAt(bufferpos);
            bufferpos++;
        }
        return true;
    }

    // runs Boolean Gates based on BufferReader
    static boolean read() {
        // reads and check for nulls while testing returning
        do {
            returning = BufferReader();
        } while (text.length() == 0);
        switch (text) {
            case "and":

                // Boolean gate "AND", keeps checking for arguments while returning ( detection
                // for '()') is false
                boolean a = read();
                while (!returning)
                    a = (read() && a);
                // tests returning again and returns value of "a"
                returning = BufferReader();
                return a;

            case "or":

                // Boolean gate "OR", keeps checking for arguments while returning ( detection
                // for '()') is false
                boolean o = read();
                while (!returning)
                    o = (read() || o);
                // tests returning again and returns value of "o"
                returning = BufferReader();
                return o;

            case "not":

                // Boolean gate "not" and tests returning
                boolean n = !read();
                returning = BufferReader();
                return n;

            default:

                // Check for Letters, subtracts 65 ("A" id) to get a value by index in list
                int t = text.charAt(0);
                t = list.get(t - 65);
                return (t == 1);
        }
    }

    public static void main(String[] args) {
        int number = MyIO.readInt();
        while (number > 0) {
            // create and clear an array list with starting variables
            list.clear();
            for (int i = 0; i < number; i++) {
                list.add(MyIO.readInt());
            }
            // place lin into a buffer amd adds a breakpoint
            buffer = MyIO.readLine();
            buffer += '\n';
            bufferpos = 0;
            // run read() function and restart
            System.out.println((read() ? 1 : 0));
            number = MyIO.readInt();
        }
    }
}