import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class People {
    public String name;
    public String famil;
    public String patronymic;


    private static Set<String> readFile() throws Exception  {
        Set<String> file = new HashSet<>();
        File f = new File("Data.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            file.add(sc.nextLine());
        }
        sc.close();

        return file;
    }

    public static Set<People> getData() throws Exception {
        Set<String> boys = new HashSet<>();
        Set<People> resolt = new HashSet<>(); 
        boys = readFile();
        for (String i : boys) resolt.add(createBoy(i));

        return resolt;
    }

    private static People createBoy(String fio) {
        String[] str = fio.split("; ");
        People boy = new People();
        boy.name = str[1];
        boy.famil = str[0];
        boy.patronymic = str[2];

        return boy;
    }

    public static String getFio(People boy) {
        return boy.famil + "; " + boy.name + "; " + boy.patronymic + "; ";
    }
}