package family_tree.infrastucture.de_serelization;
import family_tree.tree.FamilyTree;
import java.io.*;

public class File_using {


    public FamilyTree loadHumanList(){
        FamilyTree family_tree = new FamilyTree();
        System.out.println("Загрузка данных из файла. Текущий список будет удален.");
        try {
            FileInputStream fis = new FileInputStream("src/family_tree.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            family_tree = (FamilyTree) ois.readObject();
            System.out.println("Семейное древо успешно загружено.");
            System.out.println(family_tree);
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
        return family_tree;
    }

    public void saveHumanList(FamilyTree familyTree){
        System.out.println("Сохранение в файл.");
        try
        {
            FileOutputStream fos = new FileOutputStream("src/family_tree.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Загружаю " + familyTree);
            oos.writeObject(familyTree);
            oos.close();
            fos.close();
            System.out.println("Семейное древо успешно сохранено в файл.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            throw new RuntimeException(e);
        } catch(IOException ioe) {
            System.out.println ("Error while writing data");
            ioe.printStackTrace();
        }

    }
}
