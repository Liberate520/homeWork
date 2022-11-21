import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonFileUtil {

    public static void write(Person person, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(person.toString() + "\n");
            writer.flush();
        } catch (IOException e) {
            Logger.getLogger(PersonFileUtil.class.getSimpleName()).log(Level.WARNING, "Can't write to file!", e);
        }
    }

    public static void write(List<Person> person, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (Person x : person) {
                writer.write(x.toString());
            }
            writer.flush();
        } catch (IOException e) {
            Logger.getLogger(PersonFileUtil.class.getSimpleName())
                    .log(Level.WARNING, "Can't write to file - " + fileName, e);
        }
    }

    public static List<Person> read(String fileName) {
        List<Person> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while(reader.ready()) {
                result.add(Person.parse(reader.readLine()));
            }
            return result;
        } catch (IOException e) {
            Logger.getLogger(PersonFileUtil.class.getSimpleName())
                    .log(Level.WARNING, "Can't read from file - " + fileName, e);
        }
        return result;
    }
}
