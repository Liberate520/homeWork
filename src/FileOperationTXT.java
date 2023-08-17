import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class FileOperationTXT implements FileOperation {
    @Override
    public void write(String fileName, FamilyTree tree) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            List<Human> humans = tree.getAllHumans();
            for (Human human : humans) {
                writer.write(human.toString());
                writer.append("\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void read(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
