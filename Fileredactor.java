import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Fileredactor implements Saveandreadable {

    public String filename;
    private String relative;

    private Fileredactor (String filename) {
        this.filename = filename;
    }

    private Fileredactor () {
        this(null);
    }

    @Override
    public void read_info (Tree family) throws IOException {
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader breader = new BufferedReader(fr);
        String line = breader.readLine();
        List<String> data = new ArrayList<>();
        while(line != null){
            while(!line.equals("Следующий человек")){
                if (parseLine(line).length == 1){
                    data.add("-");
                }
                else{
                    switch(parseLine(line)[0]){
                        case "Имя":
                            String firstName = parseLine(line)[1];
                            data.add(firstName);
                            break;
                        case "Фамилия":
                            String lastName = parseLine(line)[1];
                            data.add(lastName);
                            break;
                        case "Дата рождения":
                            String birthDate = parseLine(line)[1];
                            data.add(birthDate);
                            break;
                        case "Дата смерти":
                            String deathDate = parseLine(line)[1];
                            data.add(deathDate);
                            break;
                        case "Пол":
                            String gender = parseLine(line)[1];
                            data.add(gender);
                            break;
                        case "Идентификационный номер":
                            String personId = parseLine(line)[1];
                            data.add(personId);
                            break;
                        case "Отец":
                            String fatherId = parseLine(line)[1];
                            data.add(fatherId);
                            break;
                        case "Мать":
                            String motherId = parseLine(line)[1];
                            data.add(motherId);
                            break;
                    }
                }
                line = breader.readLine();
            }
            Presenter presenter = new Presenter();
            Human newPerson = presenter.addHuman(data);
            family.addHuman(newPerson);
            line = breader.readLine();
        }
    }

    private static String[] parseLine(String line) {
        String [] result = line.split(": ");
        return result;
    }


    @Override
    public void print_info (Tree<Human> o) throws IOException {
        FileWriter file = new FileWriter("family.txt", true);
        file.write("\n" + relative);
        file.close();
    }

}