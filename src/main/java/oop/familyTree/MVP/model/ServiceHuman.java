package oop.familyTree.MVP.model;

import javafx.scene.control.Alert;
import oop.familyTree.human.Human;
import oop.familyTree.tree.FamilyTree;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceHuman implements SaveAndLoad{

    // Путь к папке с сохранёнными древами
    private final Path pathDirFamTree = Paths.get("./src/main/resources/archive");

    /**
     * Конструктор
     */
    public ServiceHuman() {
    }

    /**
     * Создаёт и сохраняет новое древо
     * @param treeName имя древа
     */
    public void createNewTree(String treeName){
        this.saving(treeName, new FamilyTree<>());
    }

    /**
     * Возвращение списка всех файлов с древами
     * @return List
     */
    public List<String> getNameFamilyTree() {
        List<String> list = new ArrayList<>();
        try (DirectoryStream<Path> files = Files.newDirectoryStream(pathDirFamTree)) {
            for (Path path : files){
                list.add(path.getFileName().toString().replaceAll(".ser", ""));
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return list;
    }

    /**
     * Возвращение содержимого сохранённого древа
     * @param treeName имя древа
     * @return List
     */
    public List<String> showFamilyTree(String treeName){
        FamilyTree<Human> ft = this.loading(treeName);
        return ft.showAll();
    }

    /**
     * Добавление нового человека в древо
     * @param treeName имя древа
     * @param fullName имя человека
     * @param gender пол
     * @param dateOfBirth дата рождения
     * @param dateOfDeath дата смерти
     * @param mother имя матери
     * @param father имя отца
     * @param spouse имя супруга
     * @param children имена детей
     */
    public void addNewHuman(String treeName, String fullName, String gender,
                            LocalDate dateOfBirth, LocalDate dateOfDeath,
                            String mother, String father,
                            String spouse, String children){
        FamilyTree<Human> ft = this.loading(treeName);
        ft.addNewHuman(new Human(fullName, gender,
                dateOfBirth, dateOfDeath,
                mother, father, spouse, children));
        this.saving(treeName, ft);
    }

    /**
     * Переопределение метода сохранения из SaveAndLoad
     * @param treeName имя древа
     * @param familyTree объект для сохранения
     */
    @Override
    public void saving(String treeName, FamilyTree<Human> familyTree) {
        try {
            Files.createDirectories(pathDirFamTree);
        }
        catch (Exception ex){
            Alert message = new Alert(Alert.AlertType.ERROR);
            message.setTitle("Ошибка");
            message.setContentText(ex.getMessage());
            message.showAndWait();
        }
        Path dirPath = Paths.get(pathDirFamTree + "/" + treeName + ".ser");
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(dirPath))) {
            oos.writeObject(familyTree);
        }
        catch (Exception ex){
            Alert message = new Alert(Alert.AlertType.ERROR);
            message.setTitle("Ошибка");
            message.setHeaderText("Файл не сохранён");
            message.setContentText(ex.getMessage());
            message.showAndWait();
        }
    }

    /**
     * Переопределение метода загрузки из SaveAndLoad
     * @param treeName имя древа
     * @return объект FamilyTree
     */
    @Override
    public FamilyTree<Human> loading(String treeName) {
        Path dirPath = Paths.get(pathDirFamTree + "/" + treeName + ".ser");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(dirPath))) {
            return (FamilyTree<Human>) ois.readObject();
        }
        catch (Exception ex){
            Alert message = new Alert(Alert.AlertType.ERROR);
            message.setTitle("Ошибка");
            message.setHeaderText("Файл не загружен");
            message.setContentText(ex.getMessage());
            message.showAndWait();
        }
        return new FamilyTree<>();
    }
}
