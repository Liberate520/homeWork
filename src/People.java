import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class People {
    public String name;
    public String famil;
    public String patronymic;

    private Set<People> book = new HashSet<>();
    private String tempFamil;


    private Set<String> readFile() throws Exception  {
        Set<String> file = new HashSet<>();
        File f = new File("Data.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            file.add(sc.nextLine());
        }
        sc.close();

        return file;
    }

    private People createBoy(String fio) {
        String[] str = fio.split("; ");
        People boy = new People();
        boy.name = str[1];
        boy.famil = str[0];
        boy.patronymic = str[2];

        return boy;
    }

    public void getData() throws Exception {
        Set<String> boys = new HashSet<>();
        boys = readFile();
        for (String i : boys) book.add(createBoy(i));
    }

    public String getFio(People boy) {
        return boy.famil + "; " + boy.name + "; " + boy.patronymic + "; ";
    }

    public void printBook() throws Exception {
        for (People i : book) System.out.println(getFio(i));
        System.out.printf("\n\n\n");
    }

    public void getFamil() {
        String tempFamil = inputFamil();

        for (People i : book) {
            if (i.famil.equals(tempFamil)) System.out.println(getFio(i));
        }
    }

    public void getTree() {
        String temp = inputFamil();
        int limit = 0;
        String child = "";

        for (People i : book) {
            for (People j : book) {
                if (i != j) {
                    limit = i.name.length();
                    child = j.patronymic.length() >= limit ? j.patronymic.substring(0, limit) : "";

                    if (i.name.equals(child) && i.famil.equals(j.famil)) 
                        System.out.println(i.name + " " + i.famil + " отец: " + j.name + " " + j.famil);
                }
            }
        }
    }

    private String inputFamil() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        tempFamil = in.next();

        return tempFamil;
    }
}