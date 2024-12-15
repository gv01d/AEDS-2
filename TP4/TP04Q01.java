
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.Object;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class TP04Q01 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true);

    static String separation = " ## ";

    static public class Personagens implements Comparable<Personagens> {

        String id;
        String name;
        List<String> alternate_names;
        String house;
        String ancestry;
        String species;
        String patronus;
        Boolean hogwartsStaff;
        Boolean hogwartsStudent;
        String actorName;
        Boolean alive;
        List<String> alternate_actors;
        LocalDate dateOfBirth;
        int yearOfBirth;
        String eyeColour;
        String gender;
        String hairColour;
        Boolean wizard;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getAlternate_names() {
            return alternate_names;
        }

        public void setAlternate_names(List<String> alternate_names) {
            this.alternate_names = alternate_names;
        }

        public void setAlternate_names(String[] alternate_names) {
            this.alternate_names = Arrays.asList(alternate_names);
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public String getAncestry() {
            return ancestry;
        }

        public void setAncestry(String ancestry) {
            this.ancestry = ancestry;
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getPatronus() {
            return patronus;
        }

        public void setPatronus(String patronus) {
            this.patronus = patronus;
        }

        public Boolean getHogwartsStaff() {
            return hogwartsStaff;
        }

        public void setHogwartsStaff(Boolean hogwartsStaff) {
            this.hogwartsStaff = hogwartsStaff;
        }

        public void setHogwartsStaff(String hogwartsStaff) {
            this.hogwartsStaff = hogwartsStaff.equals("VERDADEIRO");
        }

        public boolean getHogwartsStudent() {
            return hogwartsStudent;
        }

        public void setHogwartsStudent(Boolean hogwartsStudent) {
            this.hogwartsStudent = hogwartsStudent;
        }

        public void setHogwartsStudent(String hogwartsStudent) {
            this.hogwartsStudent = hogwartsStudent.equals("VERDADEIRO");
        }

        public String getActorName() {
            return actorName;
        }

        public void setActorName(String actorName) {
            this.actorName = actorName;
        }

        public Boolean getAlive() {
            return alive;
        }

        public void setAlive(Boolean alive) {
            this.alive = alive;
        }

        public List<String> getAlternate_actors() {
            return alternate_actors;
        }

        public void setAlive(String alive) {
            this.alive = alive.equals("VERDADEIRO");
        }

        public void setAlternate_actors(List<String> alternate_actors) {
            this.alternate_actors = alternate_actors;
        }

        public void setAlternate_actors(String[] alternate_actors) {
            this.alternate_actors = Arrays.asList(alternate_actors);
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-M-yyyy");
            this.dateOfBirth = LocalDate.parse(dateOfBirth, dtf);
        }

        public int getYearOfBirth() {
            return yearOfBirth;
        }

        public void setYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
        }

        public void setYearOfBirth(String yearOfBirth) {
            this.yearOfBirth = Integer.parseInt(yearOfBirth);
        }

        public String getEyeColour() {
            return eyeColour;
        }

        public void setEyeColour(String eyeColour) {
            this.eyeColour = eyeColour;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHairColour() {
            return hairColour;
        }

        public void setHairColour(String hairColour) {
            this.hairColour = hairColour;
        }

        public Boolean getWizard() {
            return wizard;
        }

        public void setWizard(Boolean wizard) {

            this.wizard = wizard;
        }

        public void setWizard(String wizard) {

            this.wizard = wizard.equals("VERDADEIRO");
        }

        Personagens(String name) {
            this.name = name;

            id = "";
            alternate_names = null;
            house = "";
            ancestry = "";
            species = "";
            patronus = "";
            hogwartsStaff = false;
            hogwartsStudent = false;
            actorName = "";
            alive = false;
            dateOfBirth = null;
            yearOfBirth = 0;
            eyeColour = "";
            gender = "";
            hairColour = "";
            wizard = false;
        }

        Personagens() {
            name = "";
            id = "";
            alternate_names = null;
            house = "";
            ancestry = "";
            species = "";
            patronus = "";
            hogwartsStaff = false;
            hogwartsStudent = false;
            actorName = "";
            alive = false;
            dateOfBirth = null;
            yearOfBirth = 0;
            eyeColour = "";
            gender = "";
            hairColour = "";
            wizard = false;
        }
        //

        // #=========================================================================#
        // # - - - - - - - - - - - - - - [ O U T P U T ] - - - - - - - - - - - - - - #
        // #=========================================================================#

        //

        // ------------------------------

        void printall() {
            idOut();
            nameOut();
            alternate_namesOut();
            houseOut();
            ancestryOut();
            speciesOut();
            patronusOut();
            hogwartsStaffOut();
            hogwartsStudentOut();
            actorNameOut();
            aliveOut();
            dateOfBirthOut();
            yearOfBirthOut();
            eyeColourOut();
            genderOut();
            hairColourOut();
            wizardOut();
        }

        // ------------------------------
        void idOut() {
            out.print(id + separation);
        }

        void nameOut() {
            out.print(name + separation);
        }

        void alternate_namesOut() {
            String[] temp = alternate_names.toArray(new String[0]);
            out.print("{");
            for (int i = 0; i < temp.length; i++) {
                out.print(temp[i]);
                if (i + 1 < temp.length)
                    out.print(",");
            }
            out.print("}" + separation);

        }

        void houseOut() {
            out.print(house + separation);
        }

        void ancestryOut() {
            out.print(ancestry + separation);
        }

        void speciesOut() {
            out.print(species + separation);
        }

        void patronusOut() {
            out.print(patronus + separation);
        }

        void hogwartsStaffOut() {
            out.print(hogwartsStaff + separation);
        }

        void hogwartsStudentOut() {
            out.print(hogwartsStudent + separation);
        }

        void actorNameOut() {
            out.print(actorName + separation);
        }

        void aliveOut() {
            out.print(alive + separation);
        }

        void dateOfBirthOut() {
            out.print(((dateOfBirth.getDayOfMonth() < 10) ? "0" + dateOfBirth.getDayOfMonth()
                    : dateOfBirth.getDayOfMonth()) + "-"
                    + ((dateOfBirth.getMonthValue() < 10) ? "0" + dateOfBirth.getMonthValue()
                            : dateOfBirth.getMonthValue())
                    + "-" + dateOfBirth.getYear()
                    + separation);
        }

        void yearOfBirthOut() {
            out.print(yearOfBirth + separation);
        }

        void eyeColourOut() {
            out.print(eyeColour + separation);
        }

        void genderOut() {
            out.print(gender + separation);
        }

        void hairColourOut() {
            out.print(hairColour + separation);
        }

        void wizardOut() {
            out.print(wizard);
        }

        @Override
        public int compareTo(Personagens o) {
            String p1 = reflectionFieldToString(compItens, this);
            String p2 = reflectionFieldToString(compItens, o);

            return p1.compareTo(p2);
        }

    }

    static String compItens[];

    static void setCompItens(String comp[]) {
        compItens = comp;
    }

    static String reflectionFieldToString(String[] fields, Personagens p) {
        String ret = "";

        try {
            Field field;
            for (String s : fields) {

                field = Personagens.class.getDeclaredField(s);

                if (s.equals("dateOfBirth")) {
                    LocalDate dOB = (LocalDate) field.get(p);
                    ret += "( " + dOB.getYear() + "-"
                            + ((dOB.getMonthValue() < 10) ? "0" + dOB.getMonthValue() : dOB.getMonthValue()) + "-"
                            + ((dOB.getDayOfMonth() < 10) ? "0" + dOB.getDayOfMonth() : dOB.getDayOfMonth()) + " )";
                } else {
                    ret += field.get(p) + "   ";
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return ret;
    }

    static <T> T[] append2Array(T[] elements, T element) {
        T[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[elements.length] = element;

        return newArray;
    }
    //

    // #=========================================================================#
    // # - - - - - - - - - - - - - - [ R E A D E R ] - - - - - - - - - - - - - - #
    // #=========================================================================#

    //

    // Dinamic Setter using STRING var name
    static Personagens setDinamic(String varName, Object value, Personagens clazz) {
        try {
            // System.out.println(value);

            String temp = varName;
            varName = "set";
            varName += (char) (temp.charAt(0) - 32);

            for (int i = 1; i < temp.length(); i++) {
                varName += temp.charAt(i);
            }

            Class<?>[] parameterType = new Class[1];
            parameterType[0] = value.getClass();

            clazz.getClass().getDeclaredMethod(varName, parameterType).invoke(clazz, value);

        } catch (Exception e) {
            System.out.println(e);
        }

        return clazz;
    }

    static int why = 3;

    // First Step on Reading CSV
    static private String[] readFirstCSV(String text) {
        String[] out = {};
        String temp = "";

        for (int i = why; i < text.length(); i++) {
            char C = text.charAt(i);
            if (C == ';') {
                out = append2Array(out, temp);
                temp = "";
            } else {
                temp += C;
            }
        }

        if (temp.length() > 0)
            out = append2Array(out, temp);

        return out;
    }

    // YE

    // Convert TEXT to ARRAY
    static String[] textToArray(String text) {
        String[] out = {};
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            char C = text.charAt(i);
            if (C == '\'' || C == '\"')
                ;
            else if (C == ';') {
                out = append2Array(out, temp);
                temp = "";
            } else {
                temp += C;
            }
        }

        if (temp.length() > 0) {
            out = append2Array(out, temp);
        }

        return out;
    }

    // Main Line reader
    static Personagens readCSVLine(String text, String[] order, Personagens clazz) {
        String temp = "";
        int mod = 0; // 0 = normal, 1 = list
        int j = 0;

        // Handles the text analisis
        for (int i = 0; i < text.length(); i++) {
            char C = text.charAt(i);

            // Nothing when in mode LIST, Execute Dinamic Seter in mode NORMAL
            if (C == ';' && (mod == 0 || mod == 2)) {
                if (mod == 2) {
                    clazz = setDinamic(order[j], textToArray(temp), clazz);
                    j++;
                    temp = "";
                    mod = 0;
                } else {
                    clazz = setDinamic(order[j], temp, clazz);
                    j++;
                    temp = "";
                }
            } else if (C == '\"' || C == '\'')
                ; // Ignore " " and ' '
            else if (C == '[') // Change mode when it finds "["
                mod = 1;
            else if (C == ']') {
                // end of mode LIST, transform text to array os String and execute Dinamic Seter
                mod = 2;
            } else {
                temp += C;
            }
        }

        if (temp.length() > 0) {
            if (mod == 0) {
                clazz = setDinamic(order[j], temp, clazz);
            } else {
                clazz = setDinamic(order[j], textToArray(temp), clazz);
            }
        }

        return clazz;
    }

    // Read CSV Function
    static Personagens[] readCSV(String filename) {
        Personagens[] out = new Personagens[0];

        try {
            BufferedReader fileR = new BufferedReader(new FileReader(filename));

            String[] order = readFirstCSV(fileR.readLine());

            String temp = "";

            while ((temp = fileR.readLine()) != null) {
                out = append2Array(out, readCSVLine(temp, order, new Personagens()));
            }

            fileR.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return out;
    }
    //

    // #=======================================================================#
    // # - - - - - - - - - - - - - - - [ A B B ] - - - - - - - - - - - - - - - #
    // #=======================================================================#

    //

    public interface Node<T> {
    }

    static public class ABNode<E extends Comparable<E>> implements Node<E> {
        ABNode<E> right, left;
        E value;

        ABNode(E val) {
            this.value = val;
            this.right = null;
            this.left = null;
        }
    }

    static public class ABB<T extends Comparable<T>> implements Comparable<ABB<T>> {
        ABNode<T> start;

        int insert(T val) {
            if (start == null) {
                start = new ABNode<T>(val);
            }
            return insert(new ABNode<>(val), start);
        }

        int insert(ABNode<T> in) {
            if (start == null) {
                start = in;
            }
            return insert(in, start);
        }

        protected int insert(ABNode<T> in, ABNode<T> nd) {
            if (in == null) {
                return -1;
            }
            if (nd == null) {
                return -1;
            }
            if (in.value.compareTo(nd.value) > 0) {
                if (nd.right == null) {
                    nd.right = in;
                    return 1;
                }
                return 1 + insert(in, nd.right);
            } else if (in.value.compareTo(nd.value) < 0) {
                if (nd.left == null) {
                    nd.left = in;
                    return 1;
                }
                return 1 + insert(in, nd.left);
            }
            return -1;
        }

        int size() {
            if (start == null) {
                return 0;
            }
            return 1 + size(start);
        }

        int size(ABNode<T> nd) {
            if (nd == null) {
                return 0;
            }
            return 1 + size(nd.right) + size(nd.left);
        }

        public int compareTo(ABB<T> av2) {
            int ret = this.size() - av2.size();

            if (ret == 0) {
                return compare(this.start, av2.start);
            }

            return ret;
        }

        public int compareFirst(ABB<T> av2) {
            int ret = this.start.value.compareTo(av2.start.value);
            return ret;
        }

        int compare(ABNode<T> nd1, ABNode<T> nd2) {
            int ret = nd1.value.compareTo(nd2.value);
            if (ret == 0) {
                return compare(nd1.right, nd2.left);
            }

            return ret;
        }

        Node<T> getNd(T val) {
            return getNd(val, start);
        }

        protected Node<T> getNd(T val, ABNode<T> nd) {
            if (nd == null) {
                return nd;
            }
            int comp = val.compareTo(nd.value);
            if (comp > 0) {
                out.print("dir ");
                return getNd(val, nd.right);
            }
            if (comp < 0) {
                out.print("esq ");
                return getNd(val, nd.left);
            }
            return nd;
        }

        Node<T> getBiggest() {
            return getBiggest(start);
        }

        protected Node<T> getBiggest(ABNode<T> nd) {
            if (nd == null) {
                return null;
            }
            while (nd.right != null) {
                nd = nd.right;
            }
            return nd;

        }

        Node<T> getSmallest() {
            return getSmallest(start);
        }

        protected Node<T> getSmallest(ABNode<T> nd) {
            if (nd == null) {
                return null;
            }
            while (nd.left != null) {
                nd = nd.left;
            }
            return nd;

        }

        Node<T> delete(T val) {
            ABNode<T> nd = start;
            ABNode<T> ndParent = null;
            int comp = val.compareTo(nd.value);
            int lc = 0;
            while (comp != 0 && nd != null) {
                ndParent = nd;
                lc = comp;
                if (comp > 0) {
                    nd = nd.right;
                }
                if (comp < 0) {
                    nd = nd.left;
                }
                comp = val.compareTo(nd.value);
            }
            ABNode<T> prox = null;
            ABNode<T> other = null;
            if (nd.right != null) {
                prox = nd.right;
                other = nd.left;
            } else if (nd.left != null) {
                prox = nd.left;
            }
            if (ndParent != null) {
                if (lc < 0) {
                    ndParent.left = prox;
                    insert(other);
                } else {
                    ndParent.right = prox;
                    insert(other);
                }
                rebalance(ndParent);
            } else {
                start = prox;
                insert(other);
                rebalance(start);
            }
            return nd;
        }

        // rotations

        Node<T> rotateLeft(ABNode<T> nd) {
            ABNode<T> x = nd.right;
            ABNode<T> y = x.left;

            x.left = nd;
            nd.right = y;
            return x;
        }

        Node<T> rotateRight(ABNode<T> nd) {
            ABNode<T> x = nd.left;
            ABNode<T> y = x.right;

            x.right = nd;
            nd.left = y;
            return x;
        }

        int rebalance(ABNode<T> nd) {
            return 0;
        }

        ABB() {
            this.start = null;
        }

    }

    //

    // #=========================================================================#
    // # - - - - - - - - - - - - - - - [ M A I N ] - - - - - - - - - - - - - - - #
    // #=========================================================================#

    //
    static Personagens find(String ID, Personagens[] characters) {
        for (Personagens p : characters) {
            if (p.id.equals(ID)) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String OS = System.getProperty("os.name").toLowerCase();

        if (OS.contains("nix") || OS.contains("nux") || OS.contains("aix")) {
            why = 1;
        }

        Personagens[] hPCharacters = readCSV("/tmp/characters.csv");

        try {

            // used for sorting
            String[] att = { "name" };

            setCompItens(att);

            String buff = in.readLine();

            // Read and add to List
            ABB<Personagens> CharList = new ABB<Personagens>();
            while (!buff.equals("FIM")) {
                Personagens p = find(buff, hPCharacters);
                if (p != null) {
                    CharList.insert(p);
                } else {
                    for (int i = 0; i < buff.length(); i++) {
                        System.err.print("[" + (int) buff.charAt(i) + "]");
                    }
                    System.err.println("ID <" + buff + "> not Found Test :" + hPCharacters[0].id);
                }
                buff = in.readLine();
            }

            String[] att2 = { "name" };

            setCompItens(att2);
            buff = in.readLine();
            while (!buff.equals("FIM")) {
                out.print(buff + " => raiz ");
                if (CharList.getNd(new Personagens(buff)) != null) {
                    out.print("SIM\n");
                } else {
                    out.print("NAO\n");
                }
                buff = in.readLine();
            }

            /*
             * BufferedWriter f = new BufferedWriter(new
             * FileWriter("matricula_mergesort.txt"));
             * f.write("820939\t" + comp + "\t" + mov);
             * // arrChar = selectionSort(arrChar, "name");
             * f.close();
             */

        } catch (Exception e) {
            out.println(e);
        }
    }
}
