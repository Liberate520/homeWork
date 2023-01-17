import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ComandSave implements Option {
    @Override
    public String dicription() {
        String save = "Сохранение файла";
        return save;
    }

    @Override
    public void execute() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(".//homeWorkOOP.//src.//familytree.out"));
        List<Human> humalis;
        for (Human human : humalis) {
            objectOutputStream.writeObject(human);
        }
        objectOutputStream.close();      
    }
}
