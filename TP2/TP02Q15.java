import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TP02Q15 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    static PrintStream out = new PrintStream(System.out, true);

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

        String separation = " ## ";

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
            out.print("[");
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
            out.print("]\n");
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

    // First Step on Reading CSV
    static private String[] readFirstCSV(String text) {
        String[] out = {};
        String temp = "";

        for (int i = 1; i < text.length(); i++) {
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
                    LocalDate dOB = (LocalDate)field.get(p);
                    ret += "( " + dOB.getYear() + "-" + ((dOB.getMonthValue() < 10) ? "0" + dOB.getMonthValue(): dOB.getMonthValue()) + "-" + ((dOB.getDayOfMonth() < 10) ? "0" + dOB.getDayOfMonth() : dOB.getDayOfMonth()) + " )";
                }
                else{
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

    static void swap(Personagens[] p, int from, int to) {
        Personagens tmp = p[from];
        p[from] = p[to];
        p[to] = tmp;
        mov += 3;
    }

    static void swap(String[] arr, int from, int to) {
        String tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

    static void swap(Personagens[] p, String[] arr, int from, int to){
        swap(arr,from,to);
        swap(p, from, to);
    }
    /*
    public void ex() {
		for (int i = 1; i < n; i++) 
        {
            int tmp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > tmp)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
	}
    */

    // ------------------------------------ MERGE SORT ------------------------------------
    static void mergeSort(Personagens[] p,String[] arr,int left,int right){
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(p, arr, left, mid);
            mergeSort(p, arr, mid+1, right);
            inbetween(p, arr, left, mid, right);
        }
    }
    static void inbetween(Personagens p[],String[] arr,int left,int mid,int right){
        int sub1 = mid - left + 1;
        int sub2 = right - mid;
        int i,j,k;
        
        Personagens[] p1 = new Personagens[sub1+1];
        for ( i = 0; i < sub1; p1[i] = p[left + i] ,i++);
        String[] a1 = new String[sub1+1];
        for ( i = 0; i < sub1; a1[i] = arr[left + i] ,i++);
        
        Personagens[] p2 = new Personagens[sub2+1];
        for ( j = 0; j < sub2; p2[j] = p[mid + j + 1] ,j++);
        String[] a2 = new String[sub2+1];
        for ( j = 0; j < sub2; a2[j] = arr[mid + j + 1] ,j++);

        a1[i] = a2[j] = "~~~~~~~~";
        p1[i] = p2[j] = new Personagens();
        
        for(i = j = 0, k = left; k <= right; k++){
            boolean test = (a1[i].compareTo(a2[j]) <= 0);
            p[k] = test ? p1[i] : p2[j];
            arr[k] = test ? a1[i++] : a2[j++];
            mov++;
            comp++;
        }
    }
    // ------------------------------------------------------------------------------------
    

    // ------------------------------------ COUNTING SORT ------------------------------------

    static int getBiggerYear(Personagens[] p,int len){
        int ret = p[0].yearOfBirth;

        for(int i = 0; i < len;i++){
            if(p[i].yearOfBirth > ret){
                ret = p[i].yearOfBirth;
            }
        }

        return ret;
    }

    static Personagens[] countingSortYear(Personagens[] p,String[] att,int len){
        int[] count = new int[getBiggerYear(p,len) + 1];
        Personagens[] tmp = new Personagens[len];

        // create count
        for(int i = 0; i < count.length; count[i] = 0, i++);

        // 
        for(int i = 0; i < len; count[p[i].yearOfBirth]++, i++);

        for(int i = 1; i < count.length; count[i] += count[i-1], i++);

        //
        for(int i = len-1; i >= 0; tmp[count[p[i].yearOfBirth]-1] = p[i], mov++, count[p[i].yearOfBirth]--, i--);

        int ctmp = tmp[0].yearOfBirth;
        int finish = 0, start = 0;
        for(int i = 1; i < len;i++){
            comp++;
            if (tmp[i].yearOfBirth == ctmp) {
                finish++;
            }
            else{
                if (finish - start > 0) {
                    sort(tmp, att, start, finish+1);
                }
                ctmp = tmp[i].yearOfBirth;
                start = i;
                finish = i;
            }
        }

        for(int i = 0; i< len; p[i] = tmp[i], i++);

        return p;
    }
    // ---------------------------------------------------------------------------------------

    // ------------------------------------ HEAP SORT ------------------------------------

    //
    static int getLarger(String[] arr,int i, int len){
        int ret;
        if (2*i == len || arr[2*i].compareTo(arr[2*i+1]) > 0) {
            ret = 2*i;
        }
        else{
            ret = 2*i+1;
        }
        return ret;
    }

    static Personagens[] heapSort(Personagens[] p,String[] arr,int len){

        // Move everything by 1 in array
        String[] tmparr = new String[len +1];
        Personagens[] tmpP = new Personagens[len +1];
        for(int i = 0;i < len;i++){
            tmparr[i+1] = arr[i];
            tmpP[i+1] = p[i];
        }

        // Build Heap
        for(int tam = 2;tam <= len;tam++){
            for(int i = tam; i > 1 && tmparr[i].compareTo(tmparr[i/2]) > 0;i/=2){
                swap(tmpP,tmparr, i, i/2);
                comp++;
            }
            comp++;
        }

        // The sorting
        int tam = len;
        while(tam > 1){
            swap(tmpP, tmparr, 1, tam--);
            // Rebuild
            int i = 1;
            while (i <= tam/2) {
                int sibling = getLarger(tmparr, i, tam);
                comp++;
                if(tmparr[i].compareTo(tmparr[sibling]) < 0){
                    swap(tmpP, tmparr, i, sibling);
                    i = sibling;
                }
                else{
                    i = tam;
                }
            }
        }
        
        // Move back
        for(int i = 0;i < len;i++){
            arr[i] = tmparr[i+1];
            p[i] = tmpP[i+1];
        }
        return p;
    }

    //

    // ------------------------------------ HEAP SORT ------------------------------------

    static Personagens[] insertionSort(Personagens[] p,String[] arr,int start, int length){
        for (int i = 1+start; i < length;i++){
            String tmp = arr[i];
            Personagens tmP = p[i];
            int j = i - 1;

            while ((j >= start) && (arr[j].compareTo(tmp) > 0)) {
                arr[j+1] = arr[j];
                p[j+1] = p[j];
                j--;

                comp++;
                mov++;
            }
            arr[j+1] = tmp;
            p[j+1] = tmP;
            comp++;
            mov++;
        }

        return p;
    }

    static Personagens[] selectionSort(Personagens[] p, String[] arr,int start, int length) {

        for (int i = start; i < (length - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < length; j++) {
                if (arr[menor].compareTo(arr[j]) > 0) {
                    menor = j;

                    comp++;
                }
            }
            swap(p, menor, i);
            swap(arr, i, menor);
        }

        return p;
    }
    static Personagens[] selectionSort(Personagens[] p, String[] arr,int start, int length,int k) {

        for (int i = start; i < k; i++) {
            int menor = i;
            for (int j = (i + 1); j < length; j++) {
                if (arr[menor].compareTo(arr[j]) > 0) {
                    menor = j;

                    comp++;
                }
            }
            swap(p, menor, i);
            swap(arr, i, menor);
        }

        return p;
    }

    static void sort(Personagens[] p, String[] att, int start, int length){
        String[] arr = new String[length];

        for (int i = start; i < length;i++) {
            arr[i] = reflectionFieldToString(att, p[i]);
        }

        mergeSort(p, arr,start, length-1);
    }
    static void sort(Personagens[] p, String[] att, int start, int length,int k){
        String[] arr = new String[length];

        for (int i = start; i < length;i++) {
            arr[i] = reflectionFieldToString(att, p[i]);
        }

        selectionSort(p, arr,start, length,k+1);
    }


    //

    // #=========================================================================#
    // # - - - - - - - - - - - - - - - [ M A I N ] - - - - - - - - - - - - - - - #
    // #=========================================================================#

    //

    public static void main(String[] args) {

        Personagens[] hPCharacters = readCSV("/tmp/characters.csv");

        try {

            String[] att = { "name" };

            String buff = in.readLine();
            Personagens[] arrChar = {};
            

            boolean found = false;
            while (!buff.equals("FIM")) {
                found = false;
                for (Personagens p : hPCharacters) {
                    if (p.id.equals(buff)) {
                        arrChar = Arrays.copyOf(arrChar, arrChar.length + 1);
                        arrChar[arrChar.length - 1] = p;
                        found = true;
                    }
                }
                if (!found) {
                    System.err.println("ID not Found");
                }
                buff = in.readLine();
            }

            sort(arrChar, att, 0, arrChar.length,10);

            for (int i = 0; i < 10;i++) {
                arrChar[i].printall();
            }

            BufferedWriter f = new BufferedWriter(new FileWriter("matricula_mergesort.txt"));
            f.write("820939\t" + comp + "\t" + mov);
            // arrChar = selectionSort(arrChar, "name");
            f.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}