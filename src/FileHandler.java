import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler implements Saveable, Readable {
    @Override
    public void save(List<Human> humalis) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(".//homeWorkOOP.//src.//familytree.out"));
        for (Human human : humalis) {
            objectOutputStream.writeObject(human);
        }
        objectOutputStream.close();
    }

    @Override
    public Tree<Human> read() throws FileNotFoundException, IOException, ClassNotFoundException {
        Tree<Human> tree = new Tree<>();
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(".//homeWorkOOP.//src.//familytree.out"));
        
        //Каким то образом нужно определить количество хьюманов в файле чтобы можно было добаить циклом в дерево
        tree.add_human((Human) objectInputStream.readObject());
        tree.add_human((Human) objectInputStream.readObject());
        tree.add_human((Human) objectInputStream.readObject());

        objectInputStream.close();
        return tree;
    }

}
