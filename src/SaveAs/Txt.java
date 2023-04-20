package SaveAs;
import FamalyTree.Human;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;

public class Txt extends TextFormat{
    private String mother;
    private String father;
    private String partner;
    @Override
    public void SaveAs(Human human, String path) {
        try (FileWriter writer = new FileWriter(path + ".txt", false)){
            if (human.getMother() == null) {mother = "null";}
            else {mother = human.getMother().toString();}
            if (human.getMother() == null) {father = "null";}
            else {father = human.getMother().toString();}
            if (human.getMother() == null) {partner = "null";}
            else {partner = human.getMother().toString();}
            writer.write(human.getGender().toString() + "|");
            writer.write(human.getFirstName() + "|");
            writer.write(human.getLastName() + "|");
            writer.write(mother + "|");
            writer.write(father + "|");
            writer.write(partner + "|");
            writer.write(human.getChildren().toString() + "\n");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
