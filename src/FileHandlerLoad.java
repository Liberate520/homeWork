import java.io.*;

public class FileHandlerLoad implements DataLoad {




    @Override
    public Object loadData(String fileName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            FamilyTree restoreFamilyTrees = (FamilyTree) objectInputStream.readObject();
            System.out.println("Восстановление данных:\n" + restoreFamilyTrees);
            objectInputStream.close();
            return restoreFamilyTrees;
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + fileName);
            return null;
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка десериализации: " + e.getMessage());
            return null;
        }
    }
}