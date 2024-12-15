
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

public class TP03Q011 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true);

    static String separation = " ## ";

    static public class Personagens {

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
    static Personagens[] readCSV(String filename, String backupFilename) {
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

    // #=========================================================================#
    // # - - - - - - - - - - - - - - - [ S O R T ] - - - - - - - - - - - - - - - #
    // #=========================================================================#

    //

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

    static int comp = 0;
    static int mov = 0;

    static void swap(Nd<Personagens> p1, Nd<Personagens> p2) {
        Personagens tmp = p1.value;
        p1.value = p2.value;
        p2.value = tmp;
        mov += 3;
    }

    static void swap(String[] arr, int from, int to) {
        String tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    static void swap(Nd<Personagens> p1, Nd<Personagens> p2, String[] arr, int from, int to) {
        swap(arr, from, to);
        swap(p1, p2);
    }
    /*
     * public void ex() {
     * for (int i = 1; i < n; i++)
     * {
     * int tmp = array[i];
     * int j = i - 1;
     * 
     * while ((j >= 0) && (array[j] > tmp)) {
     * array[j + 1] = array[j];
     * j--;
     * }
     * array[j + 1] = tmp;
     * }
     * }
     */

    //

    static void quicksort(String[] arr, int left, int right, Nd<Personagens> l, Nd<Personagens> r) {
        int i = left, j = right;
        Nd<Personagens> ni = l, nj = r;
        String pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
                ni = ni.bottom;
                comp++;
            }
            while (arr[j].compareTo(pivot) > 0) {
                j--;
                nj = nj.top;
                comp++;
            }
            if (i <= j) {
                swap(ni, nj, arr, i, j);
                mov++;
                j--;
                nj = nj.top;
                i++;
                ni = ni.bottom;
            }

            comp += 3;
        }
        if (left < j) {
            quicksort(arr, left, j, l, nj);
        }
        if (i < right) {
            quicksort(arr, i, right, ni, r);
        }
    }

    static void sort(Lista2Enc<Personagens> p, String[] att) {
        String[] arr = new String[p.size];
        Nd<Personagens> a = p.sky;

        for (int i = 0; i < p.size - 1; i++) {
            arr[i] = reflectionFieldToString(att, a.value);
            a = a.bottom;
        }

        quicksort(arr, 0, p.size - 2, p.sky, p.base);
    }

    //

    // #==========================================================================#
    // # - - - - - - - - - - - - - - - [ L I S T ] - - - - - - - - - - - - - - - #
    // #==========================================================================#

    //
    static public class Nd<E> {
        public Nd<E> top;
        public E value;
        public Nd<E> bottom;

        Nd(E value, Nd<E> bottom, Nd<E> top) {
            this.value = value;
            this.bottom = bottom;
            this.top = top;
        }

        Nd(E value, Nd<E> bottom) {
            this.value = value;
            this.bottom = bottom;
            this.top = null;
        }

        Nd(E value) {
            this.value = value;
            this.bottom = null;
            this.top = null;
        }

        Nd() {
            this.value = null;
            this.bottom = null;
            this.top = null;
        }

    }

    static public class Lista2Enc<T> {
        int size;
        boolean empty;
        Nd<T> sky;
        Nd<T> base;

        Lista2Enc() {
            sky = base = null;
            size = 0;
        }

        void insertTop(T value) {
            Nd<T> temp = new Nd<T>(value);
            if (size == 0) {
                sky = temp;
                base = temp;
            } else {
                temp.bottom = sky;
                sky.top = temp;
                sky = temp;
            }
            size++;
        }

        void insertBot(T value) {
            Nd<T> temp = new Nd<T>(value);
            if (size == 0) {
                sky = temp;
                base = temp;
                size++;
            } else {
                temp.top = base;
                base.bottom = temp;
                base = temp;
            }
            size++;
        }

        int insertIndex(T value, double index) {
            if (index > size) {
                if (size + 1 == index) {
                    insertBot(value);
                }
                return -1;
            }

            Nd<T> selected = null;
            if (size / 2 <= index) {

                selected = sky;
                for (double i = 1; i < index; i++) {
                    selected = selected.bottom;
                }
            } else {

                selected = base;
                for (double i = 1; i < index; i++) {
                    selected = selected.top;
                }
            }

            Nd<T> temp = new Nd<T>(value, selected.top, selected);
            selected.top = temp;
            temp.top.bottom = temp;
            size++;

            return 0;
        }

        T removeTop() {
            if (size > 0) {
                Nd<T> temp = sky;
                sky = sky.bottom;
                size--;

                return temp.value;
            }
            return null;
        }

        T removeBottom() {
            if (size > 0) {
                Nd<T> temp = base;
                base = base.top;
                size--;

                return temp.value;
            }
            return null;
        }

        T removeIndex(T value, double index) {

            if (index > size)
                return null;

            Nd<T> selected = null;
            if (size / 2 <= index) {

                selected = sky;
                for (double i = 1; i < index; i++) {
                    selected = selected.bottom;
                }
            } else {

                selected = base;
                for (double i = 1; i < index; i++) {
                    selected = selected.top;
                }
            }

            Nd<T> temp = selected;
            selected.top.bottom = selected.bottom;
            selected.bottom.top = selected.top;
            size--;

            return temp.value;
        }
    }

    public static class Lista<T> {
        private int lenght;
        private T[] values;

        int lenght() {
            return lenght;
        }

        @SuppressWarnings("unchecked")
        Lista() {
            lenght = 0;
            values = (T[]) new Object[0];
        }

        @SuppressWarnings("unchecked")
        Lista(int size) {
            lenght = size;
            values = (T[]) new Object[size];
        }

        Lista(T[] o) {
            lenght = o.length;
            values = o;
        }

        T getFirst() {
            return values[0];
        }

        T getLast() {
            return values[lenght - 1];
        }

        T get(int position) {
            return values[position];
        }

        void setAll(T[] values) {
            this.values = values;
        }

        void setFirst(T val) {
            values[0] = val;
        }

        void setLast(T val) {
            values[lenght - 1] = val;
        }

        void set(T val, int position) {
            values[position] = val;
        }

        void inserirInicio(T val) {
            T[] tmp = Arrays.copyOf(values, lenght + 1);
            tmp[0] = val;
            System.arraycopy(values, 0, tmp, 1, lenght);

            lenght++;
            values = tmp;
        }

        void inserirFim(T val) {
            values = Arrays.copyOf(values, lenght + 1);
            values[lenght++] = val;
        }

        void inserir(T val, int position) throws Exception {
            if (position >= lenght || position < 0) {
                throw new Exception(
                        "LIST add Exception: Position(" + position + ") greater or equall to lenght(" + lenght + ")");
            }
            T[] tmp = Arrays.copyOf(values, lenght + 1);
            tmp[position] = val;
            System.arraycopy(values, position, tmp, position + 1, lenght - position);

            lenght++;
            values = tmp;
        }

        T removerInicio() {
            T ret = values[0];
            T[] tmp = Arrays.copyOf(values, --lenght);
            System.arraycopy(values, 1, tmp, 0, lenght);

            values = tmp;
            return ret;
        }

        T removerFim() {
            T ret = values[--lenght];
            values = Arrays.copyOf(values, lenght);
            return ret;
        }

        T remover(int position) throws Exception {
            if (position >= lenght || position < 0) {
                throw new Exception(
                        "LIST add Exception: Position(" + position + ") greater or equall to lenght(" + lenght + ")");
            }
            T ret = values[position];
            T[] tmp = Arrays.copyOf(values, --lenght);
            System.arraycopy(values, position + 1, tmp, position, lenght - position);

            values = tmp;
            return ret;
        }

    }

    public static class Pilha<T> {
        private int lenght;
        private T[] values;

        int lenght() {
            return lenght;
        }

        @SuppressWarnings("unchecked")
        Pilha() {
            lenght = 0;
            values = (T[]) new Object[0];
        }

        @SuppressWarnings("unchecked")
        Pilha(int size) {
            lenght = size;
            values = (T[]) new Object[size];
        }

        void inserir(T val) {
            values = Arrays.copyOf(values, lenght + 1);
            values[lenght++] = val;
        }

        T remover() {
            lenght--;
            return values[lenght];
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

        Personagens[] hPCharacters = readCSV("/tmp/characters.csv", "tmp/characters.csv");

        try {

            // used for sorting
            String[] att = { "house", "name" };

            String buff = in.readLine();

            // Read and add to List
            Lista2Enc<Personagens> CharList = new Lista2Enc<Personagens>();
            while (!buff.equals("FIM")) {
                Personagens p = find(buff, hPCharacters);
                if (p != null) {
                    CharList.insertBot(p);
                } else {
                    for (int i = 0; i < buff.length(); i++) {
                        System.err.print("[" + (int) buff.charAt(i) + "]");
                    }
                    System.err.println("ID <" + buff + "> not Found Test :" + hPCharacters[0].id);
                }
                buff = in.readLine();
            }

            sort(CharList, att);

            int siz = CharList.size - 1;
            out.println("[ Top ]");
            for (int i = 0; i < siz; i++) {
                out.print("[" + i + separation);
                CharList.removeTop().printall();
                out.println("]");
            }
            out.println("[ Bottom ]");

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