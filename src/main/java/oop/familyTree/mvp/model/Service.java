package oop.familyTree.mvp.model;

import javafx.scene.control.Alert;
import oop.familyTree.mvp.model.human.Human;
import oop.familyTree.mvp.model.tree.FamilyTree;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service implements SaveAndLoad{

    // Путь к папке с сохранёнными древами
    private final Path pathDirFamTree = Paths.get("./src/main/resources/archive");

    /**
     * Конструктор
     */
    public Service() {
    }

    // #Методы для работы с FamilyTree

    /**
     * Получение объекта древа
     * @param treeName имя древа
     * @return FamilyTree
     */
    public FamilyTree<Human> getFamilyTree(String treeName){
        return this.loading(treeName);
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
        if (list.size() == 0){
            System.out.println("Сохранённых древ пока нет");
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
     * Сортировка древа по имени
     * @param treeName имя древа
     */
    public void sortByName(String treeName){
        FamilyTree<Human> ft = this.getFamilyTree(treeName);
        ft.sortByName();
    }

    /**
     * Сортировка древа по возрасту
     * @param treeName имя древа
     */
    public void sortByAge(String treeName){
        FamilyTree<Human> ft = this.getFamilyTree(treeName);
        ft.sortByAge();
    }

    // #Конец

    // #Методы для работы с Human

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
        ft.addNewHuman(fullName, gender,
                dateOfBirth, dateOfDeath, mother, father, spouse, children);
        this.saving(treeName, ft);
    }

    /**
     * Получение всей информации о человеке
     * @param treeName имя древа
     * @param fullName полное имя человека
     */
    public void fullInfoHuman(String treeName, String fullName){
        System.out.println(this.getFamilyTree(treeName).fullInfoHuman(fullName));
    }

    /**
     * Удаление человека
     * @param treeName имя древа
     * @param fullName имя человека
     */
    public void deletingHuman(String treeName, String fullName){
        FamilyTree<Human> ft = this.getFamilyTree(treeName);
        System.out.println(ft.deletingHuman(fullName));
        this.saving(treeName, ft);
    }

    /**
     * Изменение значения поля
     * @param treeName имя древа
     * @param fullName имя человека
     * @param numField номер поля
     * @param newValue новое значение
     */
    public void changeValueField(String treeName, String fullName, int numField, String newValue){
        FamilyTree<Human> ft = this.getFamilyTree(treeName);
        ft.changeValueField(treeName, fullName, numField, newValue);
        this.saving(treeName, ft);
    }

    // #Конец

    // #Методы интерфейса SaveAndLoad

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
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Переопределение метода загрузки из SaveAndLoad
     * @param treeName имя древа
     * @return объект FamilyTree
     */
    @Override
    @SuppressWarnings("unchecked")
    public FamilyTree<Human> loading(String treeName) {
        Path dirPath = Paths.get(pathDirFamTree + "/" + treeName + ".ser");
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(dirPath))) {
            return (FamilyTree<Human>) ois.readObject();
        }
        catch (Exception ex){
            System.out.printf("Древа с именем %s нет.(файл %s не найден.)\n", treeName, ex.getMessage());
        }
        return new FamilyTree<>();
    }
    // #Конец
}
