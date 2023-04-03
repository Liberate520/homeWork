import java.io.*;

public class FileHandlerSaver implements DataSave {
    private void saveSer(FamilyTree familyTree) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.ser"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }


    @Override
            public void saveData(FamilyTree familyTree) throws IOException, ClassNotFoundException{
            saveSer(familyTree);
            System.out.println("Файл сериализации создан");

    }

}



